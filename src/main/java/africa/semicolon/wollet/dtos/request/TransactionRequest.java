package africa.semicolon.wollet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
 @Getter
 @Setter
public class TransactionRequest {
    private String recipientAccountNumber;
    private BigDecimal amount;
    private String senderAccountNumber;
    private LocalDate date;
    private TransactionStatus status;
}
