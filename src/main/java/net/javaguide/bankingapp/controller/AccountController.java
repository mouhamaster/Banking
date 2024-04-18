package net.javaguide.bankingapp.controller;

import lombok.AllArgsConstructor;
import net.javaguide.bankingapp.dto.AccountDto;
import net.javaguide.bankingapp.service.implementation.AccountService;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts/")
public class AccountController {
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account Rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto>getAccountbyId(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

    // deposit rest api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return  ResponseEntity.ok(accountDto);
    }
    // withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //Get all account rest api
    @GetMapping("/listaccount")
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    // Delete Account Rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("account is deleted successfully");
    }
}
