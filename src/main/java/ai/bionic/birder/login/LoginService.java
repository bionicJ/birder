package ai.bionic.birder.login;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import ai.bionic.birder.user.User;

@Service
public class LoginService implements ILoginService {

    private final JdbcTemplate jtm;

    public LoginService(JdbcTemplate jtm) {
        this.jtm = jtm;
    }

    @Override
    public String findProfile(String userInput) {

        String loginType = findLoginType(userInput);
        String sql = "SELECT userId FROM users WHERE " + loginType + " = ?";

        List<User> users = jtm.query(sql, new BeanPropertyRowMapper<>(User.class), userInput);
        
        if (loginType == "username" || users.size() == 0) {
            return null;
        }

        return users.get(0).getUserId();
    }

    private String findLoginType(String userInput) {
        
        String loginType = "username";

        if (userInput.matches("[0-9]+")) {
            loginType = "phone";
        } else if (userInput.contains("@")) {
            loginType = "email";
        }

        return loginType;
    }

    @Override
    public boolean doLogin(String userId, String password) {
        return false;
    }
}