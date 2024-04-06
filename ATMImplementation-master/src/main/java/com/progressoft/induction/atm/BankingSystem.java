package com.progressoft.induction.atm;

import com.progressoft.induction.atm.exceptions.AccountNotFoundException;
import java.math.BigDecimal;

public interface BankingSystem {
    BigDecimal getAccountBalance(String accountNumber) throws AccountNotFoundException;
    void debitAccount(String accountNumber, BigDecimal amount) throws AccountNotFoundException;


    BigDecimal sumOfMoneyInAtm();
}
