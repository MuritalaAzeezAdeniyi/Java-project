package africa.semicolon.wollet.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletDepositResponse {
    private String status;
    private String amount;
    private String message;
}
