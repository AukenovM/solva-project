package kz.auk.solvaproj.controller;

import kz.auk.solvaproj.model.entity.TransactionEntity;
import kz.auk.solvaproj.service.AccountTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final AccountTransactionService accountTransactionService;

    @PostMapping("/transfer")
    @ResponseBody
    public ResponseEntity makeTransfer(@RequestBody TransactionEntity transaction) {
        accountTransactionService.transferMoney(transaction);
        return ResponseEntity.ok("Transfer good");
    }

    @PostMapping("/limit")
    @ResponseBody
    public ResponseEntity getAllLimitTransactions(@RequestParam(name = "accountNumber") String accountNumber) {
        return ResponseEntity.ok(accountTransactionService.showAllTransactions(accountNumber));
    }
}
