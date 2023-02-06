package ai.bionic.birder.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(
        path = "/api/login", 
        consumes = "application/json")
        public ResponseEntity<?> tryLogin(@RequestBody Login login) {

        String userId = loginService.findProfile(login.getUserInput());

        if (userId == null) {
            return new ResponseEntity<String>("Bad Credentials", HttpStatus.BAD_REQUEST);

        } else if (loginService.doLogin(login.getUserInput(), login.getPassword())) {
            return new ResponseEntity<String>("sessionId = l0gg3d1n", HttpStatus.OK);

        } else {
            LoginResponse res = new LoginResponse(userId);
            return new ResponseEntity<LoginResponse>(res, HttpStatus.UNAUTHORIZED);
        }
    }
}