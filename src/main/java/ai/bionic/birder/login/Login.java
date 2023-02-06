package ai.bionic.birder.login;

import java.util.Objects;
import java.util.StringJoiner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
    
    private String userInput;
    private String password;

    public Login() {
    }

    public Login(
        String userInput,
        String password) {
        
        this.userInput = userInput;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Login login = (Login) o;
        return
            Objects.equals(userInput, login.userInput) &&
            Objects.equals(password, login.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userInput, password);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Login.class.getSimpleName() + "[", "]")
            .add("userInput=" + userInput)
            .add("password=" + password)
            .toString();
    }
}
