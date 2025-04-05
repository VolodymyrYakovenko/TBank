package dev.volod.TBank.service.interfaces;

import dev.volod.TBank.dto.response.TransactionResponseDTO;

import java.math.BigDecimal;

public interface BankServiceInterface {
    TransactionResponseDTO userWithdraw(BigDecimal amount, String userId);
    TransactionResponseDTO userDeposit(BigDecimal amount, String userId);
    TransactionResponseDTO transfer(BigDecimal amount, String senderId, String receiverId);

}
