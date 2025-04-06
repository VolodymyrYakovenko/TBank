package dev.volod.TBank.controller;

import dev.volod.TBank.dto.response.TransactionResponseDTO;
import dev.volod.TBank.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tbank/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionResponseDTO>> getAll(){
         return new ResponseEntity<>(transactionService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(transactionService.findById(id), HttpStatus.FOUND);
    }
}
