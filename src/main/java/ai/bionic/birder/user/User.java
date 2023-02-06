package ai.bionic.birder.user;

import java.util.Objects;
import java.util.StringJoiner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    
    private String userId;
    private String realName;
    private String username;
    private String email;
    private String phone;
    private String located;
    private Boolean isPrivate;
    private Boolean isVerified;

    public User() {
    }

    public User(
        String userId, 
        String realName,
        String username, 
        String email,
        String phone,
        String located, 
        Boolean isPrivate,
        Boolean isVerified) {
        
        this.userId = userId;
        this.realName = realName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.located = located;
        this.isPrivate = isPrivate;
        this.isVerified = isVerified;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        User user = (User) o;
        return
            Objects.equals(userId, user.userId) &&
            Objects.equals(realName, user.realName) &&
            Objects.equals(username, user.username) &&
            Objects.equals(email, user.email) &&
            Objects.equals(phone, user.phone) &&
            Objects.equals(located, user.located) &&
            Objects.equals(isPrivate, user.isPrivate) &&
            Objects.equals(isVerified, user.isVerified);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, realName, username, email, phone, located, isPrivate, isVerified);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
            .add("userId=" + userId)
            .add("realName=" + realName)
            .add("username=" + username)
            .add("email=" + email)
            .add("phone=" + phone)
            .add("located=" + located)
            .add("isPrivate=" + isPrivate)
            .add("isVerfiied=" + isVerified)
            .toString();
    }
}
