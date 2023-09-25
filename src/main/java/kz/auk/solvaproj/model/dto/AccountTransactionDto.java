package kz.auk.solvaproj.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountTransactionDto {

    @Column(name = "transfer_sum")
    private double sum;

    @Column(name = "transfer_description")
    private String description;

    @CreationTimestamp
    private LocalDate transactionDate;
    private boolean limitExceeded;
}
