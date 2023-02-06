package ai.bionic.birder.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/search/{userId}")
    public ResponseEntity<?> findUserDetails(@PathVariable String userId, Principal principal) {

        User user = userService.findById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> noUserFound(EmptyResultDataAccessException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User found");
    }
}
