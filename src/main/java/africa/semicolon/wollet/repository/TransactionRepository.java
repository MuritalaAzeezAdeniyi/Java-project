package africa.semicolon.wollet.repository;

import africa.semicolon.wollet.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
