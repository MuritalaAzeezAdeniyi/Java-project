package africa.semicolon.wollet.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class WalletCreateRequest {
    private String accountNumber;
    private BigDecimal balance;
}
