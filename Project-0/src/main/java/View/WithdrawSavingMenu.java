package View;

import Persistance.BankAccountModel;
import Repo.BankAccountRepo;
import Utils.ContextStore;

import java.io.IOException;
import java.sql.SQLException;

public class WithdrawSavingMenu extends View {

    public WithdrawSavingMenu() {
        viewName = "menu.WithdrawSavingMenu";
        viewManager = ViewManager.getViewManager();

    }

    public void renderView()  {
        System.out.println("***********************************************");
        System.out.println("To withdraw Money to the Saving Account Menu");
        System.out.println("-----------------------------------------------");

        BankAccountRepo bankAccountRepo = new BankAccountRepo();

        System.out.printf("Your Current Saving Account is: $ %.2f \n", ContextStore.getCurrentAccount().getSavingAcctBalance());
        System.out.println("-----------------------------------------------");

        //INPUTING THE AMOUNT

        System.out.println("Withdraw Amount: ");
        double amount = viewManager.getScanner().nextDouble();
        System.out.printf("Entered Amount: $ %.2f", amount);

        //VALIDATING THE AMOUNT
        //MAKING SURE AMOUNT IS NOT ZERO

        if (amount < ContextStore.getCurrentAccount().getCheckingAcctBalance()) {


            BankAccountModel bankAccount = ContextStore.getCurrentAccount();
            bankAccount.setSavingAcctBalance((bankAccount.getSavingAcctBalance() - amount));
            bankAccountRepo.update(ContextStore.getCurrentAccount());

            System.out.println("-----------------------------------------------");
            System.out.println("Withdraw was sucessful");
            System.out.printf("Your Current Saving Account is: $ %.2f \n", ContextStore.getCurrentAccount().getSavingAcctBalance());
            System.out.println("***********************************************");
            System.out.println("\n");

        } else {

            System.out.println("You have reached your overdraw");
            System.out.printf("Your Current Saving Account is: $ %.2f \n", ContextStore.getCurrentAccount().getSavingAcctBalance());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("Not enough funds in your account");
                System.out.println("Try again");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                viewManager.navigator("menu.BankAppMainMenu");

        }

        //MOVE TO THE NEW NAVIGATOR


        viewManager.navigator("menu.BankAppMainMenu");

    }
}



