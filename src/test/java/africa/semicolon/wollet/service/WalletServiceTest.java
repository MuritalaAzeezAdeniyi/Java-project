package africa.semicolon.wollet.service;

import africa.semicolon.wollet.dtos.request.WalletDepositRequest;
import africa.semicolon.wollet.dtos.response.WalletDepositResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WalletServiceTest {
    @Autowired
   private WalletService  walletService;
    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void testCanDepositInWallet() {
        Long walletId = 200L;
        BigDecimal amount = new BigDecimal("5000");
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setId(walletId);
        walletDepositRequest.setAmount(amount);

        WalletDepositResponse walletDepositResponse = walletService.deposit(walletDepositRequest);
        assertNotNull(walletDepositResponse);
        assertEquals("SUCCESS",walletDepositResponse.getStatus());
    }
}
