package dev.volod.TBank.service;

import dev.volod.TBank.dto.response.TransactionResponseDTO;

import dev.volod.TBank.dto.response.UserResponseDTO;
import dev.volod.TBank.model.user.entity.User;
import dev.volod.TBank.service.interfaces.BankServiceInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService implements BankServiceInterface {

    UserService userService;

    public BankService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public TransactionResponseDTO userWithdraw(BigDecimal amount, String userId){
        userService.withdraw(userId, amount);
        return new TransactionResponseDTO();
    }

    @Override
    public TransactionResponseDTO userDeposit(BigDecimal amount, String userId) {
        return null;
    }

    @Override
    public TransactionResponseDTO transfer(BigDecimal amount, String senderId, String receiverId) {
        return null;
    }

}
