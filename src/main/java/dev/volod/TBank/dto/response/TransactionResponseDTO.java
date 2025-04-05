package dev.volod.TBank.dto.response;

import dev.volod.TBank.dto.request.TransactionRequestDTO;
import dev.volod.TBank.model.transaction.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class TransactionResponseDTO {
    private TransactionType type;

    private Date timestamp;

    private BigDecimal amount;

    private String accountNumberSender;

    private String accountNumberReceiver;

    public TransactionResponseDTO(TransactionType type, Date timestamp, BigDecimal amount, String accountNumberSender, String accountNumberReceiver) {
        this.type = type;
        this.timestamp = timestamp;
        this.amount = amount;
        this.accountNumberSender = accountNumberSender;
        this.accountNumberReceiver = accountNumberReceiver;
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

    public String getAccountNumberSender() {
        return accountNumberSender;
    }

    public String getAccountNumberReceiver() {
        return accountNumberReceiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponseDTO that = (TransactionResponseDTO) o;
        return type == that.type && Objects.equals(timestamp, that.timestamp) && Objects.equals(amount, that.amount) && Objects.equals(accountNumberSender, that.accountNumberSender) && Objects.equals(accountNumberReceiver, that.accountNumberReceiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, amount, accountNumberSender, accountNumberReceiver);
    }

    @Override
    public String toString() {
        return "TransactionResponseDTO{" +
                "type=" + type +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                ", accountNumberSender='" + accountNumberSender + '\'' +
                ", accountNumberReceiver='" + accountNumberReceiver + '\'' +
                '}';
    }
}
