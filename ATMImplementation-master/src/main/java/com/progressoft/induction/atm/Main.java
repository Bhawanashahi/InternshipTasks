package com.progressoft.induction.atm;

import com.progressoft.induction.atm.Impl.ATMImpl;
import com.progressoft.induction.atm.Impl.BankingSystemImpl;
import com.progressoft.induction.atm.exceptions.AccountNotFoundException;
import com.progressoft.induction.atm.exceptions.InsufficientFundsException;
import com.progressoft.induction.atm.exceptions.NotEnoughMoneyInATMException;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        BankingSystem bankingSystem = new BankingSystemImpl();
        ATM atm = new ATMImpl(bankingSystem);

        try {
            System.out.println("Total money in ATM before withdrawal: " + ((BankingSystemImpl) bankingSystem).sumOfMoneyInAtm());
            String accountNumber = "123456789";
            BigDecimal amountToWithdraw = new BigDecimal("150.0");
            List<Banknote> banknotes = atm.withdraw(accountNumber, amountToWithdraw);


            System.out.println("Withdrawn: " + amountToWithdraw + " from account " + accountNumber);
            System.out.println("Banknotes dispensed: " + banknotes);

            System.out.println("Total money in ATM after withdrawal: " + ((BankingSystemImpl) bankingSystem).sumOfMoneyInAtm());
        } catch (AccountNotFoundException | InsufficientFundsException | NotEnoughMoneyInATMException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
