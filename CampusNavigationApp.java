import java.util.*;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InvalidAccountNumberException extends Exception{
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception{
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidBalanceException extends Exception{
    public InvalidBalanceException(String message) {
        super(message);
    }
}

interface LoanService {   
    void applyLoan(double amount);
}

abstract class BankAccount {
    private int accountNumber;
    private String holdername;
    protected double balance;
    private String email;

    public BankAccount(int accountNumber, String holdername, double balance, String email) throws InvalidEmailException, InvalidAccountNumberException, InvalidNameException, InvalidBalanceException 
        if(accountNumber <= 0) {
            throw new InvalidAccountNumberException("Account number must be positive.");
        }
        if(holdername == null || holdername.isEmpty()) {
            throw new InvalidNameException("Holder name cannot be empty.");
        }
        if(balance < 0) {
            throw new InvalidBalanceException("Balance cannot be negative.");
        }
        if(email.matches("^[a-zA-Z0-9.-]@[a-zA-Z0-9.-]+$")) {
            throw new InvalidEmailException("Invalid email format.");
        }
        {
        this.accountNumber = accountNumber;
        this.holdername = holdername;
        this.balance = balance;
        this.email = email;
        }
    

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount<=0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }

        if (amount<=balance) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            throw new InvalidAmountException("Deposit amount must be less than or equal to current balance.");
        }
    }