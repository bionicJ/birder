package ai.bionic.birder.login;

import java.util.Objects;
import java.util.StringJoiner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    
    private Boolean authenticated;
    private String accountId;

    public LoginResponse() {
    }

    public LoginResponse(
        String accountId) {
        
        this.authenticated = false;
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        LoginResponse loginResponse = (LoginResponse) o;
        return
            Objects.equals(authenticated, loginResponse.authenticated) &&
            Objects.equals(accountId, loginResponse.accountId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authenticated, accountId);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Login.class.getSimpleName() + "[", "]")
            .add("authenticated=" + authenticated)
            .add("accountId=" + accountId)
            .toString();
    }
}
