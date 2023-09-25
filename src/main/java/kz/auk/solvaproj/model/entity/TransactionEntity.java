package kz.auk.solvaproj.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountFrom;
    private String accountTo;

    @Column(name = "transaction_currency")
    private String currency;

    @Column(name = "transfer_sum")
    private double sum;
    @Column(name = "transfer_description")
    private String description;

    @CreationTimestamp
    private LocalDate transactionDate;

    private boolean limitExceeded;

}

