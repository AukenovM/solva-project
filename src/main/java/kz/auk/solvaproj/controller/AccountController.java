package kz.auk.solvaproj.controller;

import kz.auk.solvaproj.model.dto.AccountDto;
import kz.auk.solvaproj.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity createAccount(@RequestBody AccountDto account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account was created");
    }

    @GetMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(accountService.accountList());
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity updateAccount(@PathVariable(name = "accountId") Long id, @RequestBody AccountDto accountDto) {
        accountService.updateAccount(id, accountDto);
        return ResponseEntity.ok("Account updated");
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity deleteAccount(@PathVariable(name = "accountId") Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }
}
