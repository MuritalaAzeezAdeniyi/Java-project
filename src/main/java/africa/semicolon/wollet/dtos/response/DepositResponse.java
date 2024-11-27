package africa.semicolon.wollet.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepositResponse {
    private String message;
    private String status;
    private String amount;
}
