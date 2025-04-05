package dev.volod.TBank.service.interfaces;

import dev.volod.TBank.dto.response.TransactionResponseDTO;

import java.math.BigDecimal;

public interface BankServiceInterface {
    TransactionResponseDTO withdraw(BigDecimal amount, String userId);
    TransactionResponseDTO deposit(BigDecimal amount, String userId);
    TransactionResponseDTO transfer(BigDecimal amount, String senderId, String receiverId);

}
