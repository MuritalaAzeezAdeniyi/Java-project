package africa.semicolon.wollet.dtos.response;

import africa.semicolon.wollet.model.Wallet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWalletResponse {
    private String message;
    private Wallet wallet;
}

