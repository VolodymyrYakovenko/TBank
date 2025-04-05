package dev.volod.TBank.model.transaction.entity;

import dev.volod.TBank.model.transaction.enums.TransactionStatus;
import dev.volod.TBank.model.transaction.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jdk.jfr.Enabled;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    private TransactionType type;

    private Date timestamp;
    @NotNull
    @PositiveOrZero
    private BigDecimal amount;
    @NotNull
    private String currency;
    @NotNull
    private String accountNumberSender;
    @NotNull
    private String accountNumberReceiver;

//    private TransactionStatus status;

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


    public Transaction(TransactionType type, Date timestamp, BigDecimal amount, String currency, String accountNumberSender, String accountNumberReceiver, String description, String reference) {
        this.type = type;
        this.timestamp = timestamp;
        this.amount = amount;
        this.currency = currency;
        this.accountNumberSender = accountNumberSender;
        this.accountNumberReceiver = accountNumberReceiver;
//        this.status = status;
        this.description = description;
        this.reference = reference;
    }

    public Transaction() {

    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAccountNumberSender() {
        return accountNumberSender;
    }

    public String getAccountNumberReceiver() {
        return accountNumberReceiver;
    }

//    public TransactionStatus getStatus() {
//        return status;
//    }

    public String getDescription() {
        return description;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(timestamp, that.timestamp) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(accountNumberSender, that.accountNumberSender) && Objects.equals(accountNumberReceiver, that.accountNumberReceiver) && Objects.equals(description, that.description) && Objects.equals(reference, that.reference);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", accountNumberSender='" + accountNumberSender + '\'' +
                ", accountNumberReceiver='" + accountNumberReceiver + '\'' +
//                ", status=" + status +
                ", description='" + description + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, timestamp, amount, currency, accountNumberSender, accountNumberReceiver, description, reference);
    }
}
