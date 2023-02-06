package ai.bionic.birder.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final JdbcTemplate jtm;

    public UserService(JdbcTemplate jtm) {
        this.jtm = jtm;
    }

    @Override
    public List<User> findAll() {

        String sql = "SELECT userId, username FROM users";

        List<User> users = jtm.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findById(String userId) {

        String sql = "SELECT userId, realName, username, email, phone, located, isPrivate, isVerified FROM users WHERE userId = ?";

        User user = jtm.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
        return user;
    }
}