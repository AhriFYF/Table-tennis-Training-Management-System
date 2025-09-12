package com.system.tabletennis_training_management_system.pojo.dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserDto {

    private Integer userId;

    @NotBlank(message = "用户名不能为空")
    @JsonAlias({"userName","user_name"})
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min=6, max=12)
    @JsonAlias({"password"})
    private String password;

    @Email(message = "email格式不正确")
    @JsonAlias({"email"})
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
