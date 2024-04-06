
package com.progressoft.induction.atm.Impl;

        import com.progressoft.induction.atm.ATM;
        import com.progressoft.induction.atm.Banknote;
        import com.progressoft.induction.atm.exceptions.AccountNotFoundException;
        import com.progressoft.induction.atm.exceptions.InsufficientFundsException;
        import com.progressoft.induction.atm.exceptions.NotEnoughMoneyInATMException;

        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;

public class ATMImpl implements ATM {
    private final BankingSystemImpl bankingSystem=new BankingSystemImpl();
    @Override
    public List<Banknote> withdraw(String accountNumber, BigDecimal amount) {
        BigDecimal balance = bankingSystem.getAccountBalance(accountNumber);
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in account.");
        }

        // Check if the ATM has enough money
        BigDecimal atmTotal = calculateATMTotal();
        if (atmTotal.compareTo(amount) < 0) {
            throw new NotEnoughMoneyInATMException("Not enough money in the ATM.");
        }

        // Deduct amount from account and ATM, then return the banknotes
        bankingSystem.debitAccount(accountNumber, amount);
        return dispenseMoney(amount);
    }

    private BigDecimal calculateATMTotal() {
        // Implementation to calculate total money in ATM
        return BigDecimal.ZERO; // Placeholder
    }

    private List<Banknote> dispenseMoney(BigDecimal amount) {
        // Implementation to dispense money and update the ATM's money store
        return null; // Placeholder
    }


    @Override
    public BigDecimal checkBalance(String accountNumber) {
        return bankingSystem.getAccountBalance(accountNumber);
    }
}

