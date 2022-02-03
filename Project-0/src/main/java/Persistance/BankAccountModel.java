package Persistance;

public class BankAccountModel {
    private Integer mainBankAccountNumber;
    private double checkingAcctBalance;
    private double savingAcctBalance;
    private Integer clientId;

    public BankAccountModel() {

    }

    public BankAccountModel(double checkingAcctBalance, double savingAcctBalance, Integer clientId) {
        this.checkingAcctBalance = checkingAcctBalance;
        this.savingAcctBalance = savingAcctBalance;
        this.clientId = clientId;
    }

    //BankAccountModel GETTER & SETTERS

    public BankAccountModel(double checkingAcctBalance) {
        this.checkingAcctBalance = checkingAcctBalance;
    }

    public int getMainBankAccountNumber() {
        return mainBankAccountNumber;
    }

    public void setMainBankAccountNumber(Integer mainBankAccountNumber) {
        this.mainBankAccountNumber = mainBankAccountNumber;
    }

    public double getCheckingAcctBalance() {
        return checkingAcctBalance;
    }

    public void setCheckingAcctBalance(double checkingAcctBalance) {
        this.checkingAcctBalance = checkingAcctBalance;
    }


    public double getSavingAcctBalance() {
        return savingAcctBalance;
    }

    public void setSavingAcctBalance(double savingAcctBalance) {
        this.savingAcctBalance = savingAcctBalance;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}