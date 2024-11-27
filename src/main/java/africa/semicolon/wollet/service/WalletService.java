package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.WalletCreateRequest;
import africa.semicolon.wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.wollet.dtos.response.CreateWalletResponse;
import africa.semicolon.wollet.dtos.response.WalletDepositResponse;

public interface WalletService {
    WalletDepositResponse deposit(WalletDepositRequest request);
    CreateWalletResponse createWallet(WalletCreateRequest request);
}
