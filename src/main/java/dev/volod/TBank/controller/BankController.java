package dev.volod.TBank.controller;

import dev.volod.TBank.dto.request.TransactionRequestDTO;
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
    public ResponseEntity<TransactionRequestDTO> transfer(@RequestParam BigDecimal amount, @RequestParam String senderId, @RequestParam String receiverId){
        return new ResponseEntity<>(new TransactionRequestDTO(), HttpStatus.OK);
    }

    @GetMapping("/deposit")
    public ResponseEntity<TransactionRequestDTO> deposit(){
        return new ResponseEntity<>(new TransactionRequestDTO(), HttpStatus.OK);
    }

    @GetMapping("/withdraw")
    public ResponseEntity<TransactionRequestDTO> witdhraw(){
        return new ResponseEntity<>(new TransactionRequestDTO(), HttpStatus.OK);
    }

}
