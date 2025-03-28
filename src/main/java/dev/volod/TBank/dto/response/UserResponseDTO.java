package dev.volod.TBank.dto.response;

import dev.volod.TBank.model.user.enums.Gender;

import java.math.BigDecimal;
import java.util.Objects;

public record UserResponseDTO(
        String id,
        String username,
        BigDecimal balance,
        String firstName,
        String lastName,
        Gender gender,
        String email) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDTO that = (UserResponseDTO) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(balance, that.balance) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && gender == that.gender && Objects.equals(email, that.email);
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
