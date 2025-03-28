package dev.volod.TBank.model.transaction.entity;

import dev.volod.TBank.model.transaction.enums.TransactionStatus;
import dev.volod.TBank.model.transaction.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;


public class Transaction {

    private String id;

    private TransactionType type;

    private Date timestamp;

    private BigDecimal amount;

    private String currency;

    private String accountNumberSender;

    private String accountNumberReceiver;

    private TransactionStatus status;

    private String description;

    private String reference;

    // Additional fields

    // private User user;
    // private Account accountSender;
    // private Account accountReceiver;

    // private String paymentMethod;
    // private String merchantId;
    // private String terminalId;
    // private String location;
    // private Map<String, String> metadata;

}
