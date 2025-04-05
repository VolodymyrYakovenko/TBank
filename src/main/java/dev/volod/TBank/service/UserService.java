package dev.volod.TBank.service;

import dev.volod.TBank.dto.request.UserRequestDTO;
import dev.volod.TBank.dto.response.UserResponseDTO;
import dev.volod.TBank.exception.NotEnoughCreditsException;
import dev.volod.TBank.exception.UserNotFoundException;
import dev.volod.TBank.exception.UsernameAlreadyExistsException;
import dev.volod.TBank.model.user.entity.User;
import dev.volod.TBank.repository.UserRepository;
import dev.volod.TBank.service.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponseDTO> findAll() {
        List<User> user = repository.findAll();
        List<UserResponseDTO> userDTOs = new ArrayList<>();
        user.stream()
                .forEach(
                        user1 -> {
                            userDTOs.add(new UserResponseDTO(
                                    user1.getId(),
                                    user1.getUsername(),
                                    user1.getBalance(),
                                    user1.getFirstName(),
                                    user1.getSecondName(),
                                    user1.getGender(),
                                    user1.getEmail()
                            ));
                        }
                );
        return userDTOs;
    }

    public UserResponseDTO findById(String id) {
        User user = findByIdAdmin(id);

        return new UserResponseDTO(user.getId(), user.getUsername(), user.getBalance(), user.getFirstName(), user.getSecondName(), user.getGender(), user.getEmail());
    }

    public UserResponseDTO save(UserRequestDTO userDTO) {
        User exists = repository.findUserByUsername(userDTO.username());
        if(exists != null) throw new UsernameAlreadyExistsException("Username already exists: " + userDTO.username());
        User user = new User(userDTO.username(),
                userDTO.password(),
                BigDecimal.valueOf(0.0),
                userDTO.email(),
                userDTO.firstName(),
                userDTO.secondName(),
                userDTO.gender(),
                userDTO.birthday());
        User created = repository.save(user);
        return new UserResponseDTO(created.getId(), created.getUsername(), created.getBalance(), created.getFirstName(), created.getSecondName(), created.getGender(), created.getEmail());
    }

    public UserResponseDTO update(String id, UserRequestDTO updatedUser) {
        User existingUser = findByIdAdmin(id);
        existingUser.setUsername(updatedUser.username());
        existingUser.setEmail(updatedUser.email());
        existingUser.setFirstName(updatedUser.firstName());
        existingUser.setSecondName(updatedUser.secondName());
        existingUser.setGender(updatedUser.gender());
        existingUser.setBirthday(updatedUser.birthday());
        User updated = repository.save(existingUser);
        return new UserResponseDTO(
                updated.getId(),
                updated.getUsername(),
                updated.getBalance(),
                updated.getFirstName(),
                updated.getSecondName(),
                updated.getGender(),
                updated.getEmail()
        );
    }

    public void delete(String id){
        repository.delete(repository.findById(id).orElseThrow(() -> new UserNotFoundException("Username is not found. ID: " + id)));
    }

    public User findByIdAdmin(String userID){
        return repository.findById(userID).orElseThrow(() -> new UserNotFoundException("Username is not found. ID: " + userID));
    }

    public boolean withdraw(String userID, BigDecimal amount){
        User user = findByIdAdmin(userID);
        if(user.getBalance().compareTo(amount) < 0){
            throw new NotEnoughCreditsException(userID + "\nNot enough credits to complete operation");
        }
        user.setBalance(user.getBalance().subtract(amount));
        return true;
    }

    public boolean deposit(String userID, BigDecimal amount){
        User user = findByIdAdmin(userID);
        user.setBalance(user.getBalance().add(amount));
        return true;
    }
}
