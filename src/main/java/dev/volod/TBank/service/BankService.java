package dev.volod.TBank.service;

import dev.volod.TBank.dto.response.TransactionResponseDTO;

import dev.volod.TBank.dto.response.UserResponseDTO;
import dev.volod.TBank.model.transaction.entity.Transaction;
import dev.volod.TBank.model.transaction.enums.TransactionType;
import dev.volod.TBank.model.user.entity.User;
import dev.volod.TBank.service.interfaces.BankServiceInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class BankService implements BankServiceInterface {

    UserService userService;

    TransactionService transactionService;

    public BankService(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }
    @Override
    public TransactionResponseDTO withdraw(BigDecimal amount, String userId){
        userService.withdraw(userId, amount);
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAl, timeStamp, amount, "$", userId, "SYSTEM", "", "");
        return new TransactionResponseDTO(
                transaction.getType(),
                transaction.getTimestamp(),
                transaction.getAmount(),
                transaction.getAccountNumberSender(),
                transaction.getAccountNumberReceiver()
        );
    }

    @Override
    public TransactionResponseDTO deposit(BigDecimal amount, String userId) {
        userService.deposit(userId, amount);
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, timeStamp, amount, "$", userId, "SYSTEM", "", "");
        return new TransactionResponseDTO(
                transaction.getType(),
                transaction.getTimestamp(),
                transaction.getAmount(),
                transaction.getAccountNumberSender(),
                transaction.getAccountNumberReceiver()
        );
    }

    @Override
    public TransactionResponseDTO transfer(BigDecimal amount, String senderId, String receiverId) {
        userService.withdraw(senderId, amount);
        userService.deposit(receiverId, amount);
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Transaction transaction = new Transaction(TransactionType.TRANSFER, timeStamp, amount, "$", senderId, receiverId, "", "");
        return new TransactionResponseDTO(
                transaction.getType(),
                transaction.getTimestamp(),
                transaction.getAmount(),
                transaction.getAccountNumberSender(),
                transaction.getAccountNumberReceiver()
        );
    }

}
