package africa.semicolon.wollet.repository;

import africa.semicolon.wollet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
