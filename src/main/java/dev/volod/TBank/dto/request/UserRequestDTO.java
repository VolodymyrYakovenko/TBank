package dev.volod.TBank.dto.request;

import dev.volod.TBank.model.user.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public record UserRequestDTO(
        @NotNull
        @Size(min = 4, max = 40)
        String username,
        @NotNull
        Gender gender,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Past
        Date birthday,
        @NotNull
        String firstName,
        @NotNull
        String secondName,
        @NotNull
        @Size(min = 5, max = 100)
        String password,
        @Email
        String email) {
    public UserRequestDTO(String username, Gender gender, Date birthday, String firstName, String secondName, String password, String email) {
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
    }


    @Override
    public String username() {
        return username;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public Date birthday() {
        return birthday;
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String secondName() {
        return secondName;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequestDTO that = (UserRequestDTO) o;
        return Objects.equals(username, that.username) && gender == that.gender && Objects.equals(birthday, that.birthday) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, gender, birthday, firstName, secondName, password);
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "username='" + username + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String email() {
        return email;
    }
}
