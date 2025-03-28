package dev.volod.TBank.service;

import dev.volod.TBank.dto.response.TransactionResponseDTO;

import dev.volod.TBank.dto.response.UserResponseDTO;
import dev.volod.TBank.model.user.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService {

    UserService userService;

    public BankService(UserService userService) {
        this.userService = userService;
    }

    public TransactionResponseDTO userWithdraw(BigDecimal amount, String userId){
        return new TransactionResponseDTO();
    }

}
