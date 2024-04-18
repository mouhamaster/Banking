package net.javaguide.bankingapp.service;

import net.javaguide.bankingapp.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id , double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}
