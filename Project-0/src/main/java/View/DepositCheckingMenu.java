package View;

import Persistance.BankAccountModel;
import Repo.BankAccountRepo;
import Utils.ContextStore;

import java.io.IOException;
import java.sql.SQLException;

public class DepositCheckingMenu extends View {

    public DepositCheckingMenu() {
        viewName = "menu.DepositCheckingMenu";
        viewManager = ViewManager.getViewManager();
    }

    public void renderView(){

        System.out.println("***********************************************");
        System.out.println("To Deposit Money to the Checking Account Menu");
        System.out.println("-----------------------------------------------");

        BankAccountRepo bankAccountRepo = new BankAccountRepo();

        System.out.printf("Your Current Checking Account is: $ %.2f \n", ContextStore.getCurrentAccount().getCheckingAcctBalance());
        System.out.println("-----------------------------------------------");

        //INPUTING THE AMOUNT

        System.out.println("Deposit Amount: ");
        double amount = viewManager.getScanner().nextDouble();
        System.out.printf("Entered Amount: $ %.2f", amount);

        //VALIDATING THE AMOUNT

        if (amount >= 0) {

            BankAccountModel bankAccount = ContextStore.getCurrentAccount();
            bankAccount.setCheckingAcctBalance(bankAccount.getCheckingAcctBalance() + amount);
            bankAccountRepo.update(ContextStore.getCurrentAccount());

            System.out.println("-----------------------------------------------");
            System.out.println("Deposit was sucessful");
            System.out.printf("Your Current Checking Account is: $ %.2f \n", ContextStore.getCurrentAccount().getCheckingAcctBalance());
            System.out.println("***********************************************");
            System.out.println("\n");


        }

        //MOVE TO THE NEW NAVIGATOR

        viewManager.navigator("menu.BankAppMainMenu");

    }

}
