package dev.volod.TBank.service;

import dev.volod.TBank.dto.request.TransactionRequestDTO;
import dev.volod.TBank.dto.response.TransactionResponseDTO;
import dev.volod.TBank.exception.TransactionNotFoundException;
import dev.volod.TBank.model.transaction.entity.Transaction;
import dev.volod.TBank.repository.TransactionRepository;
import dev.volod.TBank.repository.UserRepository;
import dev.volod.TBank.service.interfaces.TransactionServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionService implements TransactionServiceInterface {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionResponseDTO> findAll(){
        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionResponseDTO> transactionResponseDTOs = new ArrayList<>();
        transactionList.stream()
                .forEach(
                        transaction -> {
                            transactionResponseDTOs.add(new TransactionResponseDTO(
                                    transaction.getType(),
                                    transaction.getTimestamp(),
                                    transaction.getAmount(),
                                    transaction.getAccountNumberSender(),
                                    transaction.getAccountNumberReceiver()
                            ));
                        }
                );
        return transactionResponseDTOs;
    }

    public TransactionResponseDTO findById(String id){
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction is not found. ID: " + id));
        return new TransactionResponseDTO(
                transaction.getType(),
                transaction.getTimestamp(),
                transaction.getAmount(),
                transaction.getAccountNumberSender(),
                transaction.getAccountNumberReceiver()
        );
    }

//    public TransactionResponseDTO save(TransactionRequestDTO requestDTO){
//        return new TransactionResponseDTO();
//    }
}
