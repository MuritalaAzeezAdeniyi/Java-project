package africa.semicolon.wollet.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TransactionResponse {
    private Long id;
    private String status;
    private String recipientAccountNumber;
    private String senderAccountNumber;
    private LocalDate date;
    private Double amount;
    private String description;
}
