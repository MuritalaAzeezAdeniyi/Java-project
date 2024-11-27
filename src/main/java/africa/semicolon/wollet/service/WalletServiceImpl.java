package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.WalletCreateRequest;
import africa.semicolon.wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.wollet.dtos.response.CreateWalletResponse;
import africa.semicolon.wollet.dtos.response.WalletDepositResponse;
import africa.semicolon.wollet.execption.WalletNotFoundExepction;
import africa.semicolon.wollet.model.Wallet;
import africa.semicolon.wollet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static africa.semicolon.wollet.dtos.response.DepositStatus.SUCCESS;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
    private  final WalletRepository walletRepo;
    @Override
    public WalletDepositResponse deposit(WalletDepositRequest request) throws WalletNotFoundExepction {
        Wallet wallet = walletRepo.findById(request.getId())
                .orElseThrow(()-> new WalletNotFoundExepction(String.format("wallet with %d not found", request.getId())));
        wallet.setBalance(wallet.getBalance().add(request.getAmount()));
        walletRepo.save(wallet);
        WalletDepositResponse response = new WalletDepositResponse();
        response.setAmount(response.getAmount());
        response.setStatus(SUCCESS.toString());
        return response;
    }

    @Override
    public CreateWalletResponse createWallet(WalletCreateRequest request) {
        Wallet wallet = new Wallet();
        wallet.setBalance(wallet.getBalance());
        wallet.setAccountNumber(wallet.getAccountNumber());
        walletRepo.save(wallet);
        CreateWalletResponse response = new CreateWalletResponse();
        response.setMessage("Wallet created");
        return response;
    }


}
