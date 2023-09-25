package kz.auk.solvaproj.repository;

import kz.auk.solvaproj.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> getAllByAccountFromAndLimitExceeded(String accountNumber, boolean isLimit);
}
