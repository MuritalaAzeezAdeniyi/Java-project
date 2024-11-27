package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.TransactionRequest;
import africa.semicolon.wollet.dtos.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest transactionRequest);
}
