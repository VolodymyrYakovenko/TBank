package dev.volod.TBank.generator;

import dev.volod.TBank.dto.request.TransactionRequestDTO;
import dev.volod.TBank.dto.response.TransactionResponseDTO;
import dev.volod.TBank.model.transaction.entity.Transaction;
import dev.volod.TBank.model.transaction.enums.TransactionType;
import dev.volod.TBank.service.TransactionService;

public class TransactionIdGenerator {

    public String generator(TransactionType type){
        /**
         * Generates a unique transaction ID based on the transaction type.
         *
         * @param transactionType Type of transaction: "TRANSFER", "DEPOSIT", or "WITHDRAW".
         *                        Determines the prefix of the ID:
         *                        - "TRANSFER" → "TR"
         *                        - "DEPOSIT"  → "DE"
         *                        - "WITHDRAW" → "WI"
         *
         * @return A string in the format <Prefix>-<ThreeDigits>-<ThreeDigits>, e.g., TR-123-456.
         *         May throw an exception or return a default value if the type is invalid.
         */

        String prefix = switch (type){
            case TransactionType.TRANSFER -> "TR";
            case TransactionType.DEPOSIT -> "DE";
            case TransactionType.WITHDRAWAl -> "WI";
            default -> throw new IllegalArgumentException("Unknown transaction type");
        };

        String randomPart = String.format("%03d-%03d", (int)(Math.random() * 1000), (int)(Math.random() * 1000));

        return prefix + "-" + randomPart;
    }
}
