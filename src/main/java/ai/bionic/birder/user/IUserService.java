package ai.bionic.birder.user;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(String userId);
}