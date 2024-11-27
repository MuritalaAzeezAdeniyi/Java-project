package africa.semicolon.wollet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Wallet {
    @Id
    private Long id;
    private BigDecimal balance;
    private String accountNumber;

    public Wallet() {
        balance = BigDecimal.ZERO;
    }
}
