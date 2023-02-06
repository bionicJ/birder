package ai.bionic.birder.login;

public interface ILoginService {

    String findProfile(String userInput);
    boolean doLogin(String userId, String password);
}