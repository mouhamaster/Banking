package net.javaguide.bankingapp.mapper;

import net.javaguide.bankingapp.dto.AccountDto;
import net.javaguide.bankingapp.entities.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto (Account account){
       AccountDto accountDto= new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }
}
