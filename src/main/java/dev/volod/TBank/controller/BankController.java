package dev.volod.TBank.controller;

import dev.volod.TBank.dto.request.TransactionRequestDTO;
import dev.volod.TBank.dto.response.TransactionResponseDTO;
import dev.volod.TBank.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/tbank")
public class BankController {

    BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/transfer")
    public ResponseEntity<TransactionResponseDTO> transfer(@RequestParam BigDecimal amount, @RequestParam String senderId, @RequestParam String receiverId){
        TransactionResponseDTO response = bankService.transfer(amount, senderId, receiverId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/deposit")
    public ResponseEntity<TransactionResponseDTO> deposit(@RequestParam BigDecimal amount, @RequestParam String senderId){
        TransactionResponseDTO response = bankService.deposit(amount, senderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/withdraw")
    public ResponseEntity<TransactionResponseDTO> withdraw(@RequestParam BigDecimal amount, @RequestParam String senderId){
        TransactionResponseDTO response = bankService.withdraw(amount, senderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
