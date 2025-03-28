package dev.volod.TBank.service.interfaces;

import dev.volod.TBank.dto.request.UserRequestDTO;
import dev.volod.TBank.dto.response.UserResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface UserServiceInterface {
    List<UserResponseDTO> findAll();
    UserResponseDTO findById(String id);
    UserResponseDTO save(UserRequestDTO userDTO);
    UserResponseDTO update(String id, UserRequestDTO updatedUser);
    void delete(String id);
    boolean withdraw(String userID, BigDecimal amount);
    boolean deposit(String userID, BigDecimal amount);
}
