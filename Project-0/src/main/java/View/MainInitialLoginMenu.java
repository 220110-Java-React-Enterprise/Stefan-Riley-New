package View;

import Persistance.BankAccountModel;
import Persistance.ClientInformationModel;
import Repo.BankAccountRepo;
import Repo.ClientInformationRepo;
import Utils.ContextStore;

import java.io.IOException;
import java.sql.SQLException;

public class MainInitialLoginMenu extends View {
    public MainInitialLoginMenu() {
        viewName = "menu.MainInitialLoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    public void renderView()  {
        System.out.println("************* THANKS FOR CHOSING THE LOGIN OPTION ************* ");
        System.out.println("Accessing your account now...");
        System.out.println("________________________________________________________");

        //username
        System.out.println("Enter your username : ");
        String username = viewManager.getScanner().nextLine();

        //Password
        System.out.println("Enter your password : ");
        String password = viewManager.getScanner().nextLine();
        System.out.println("Processing  information now...");
        System.out.println("________________________________________________________");

        //CONNECTING TO DATABASE

        ClientInformationRepo repo = new ClientInformationRepo();
        ClientInformationModel newUser = repo.authenticate(username, password);
        if (newUser == null) {
            System.out.println("Incorrect information --- please try again");
            viewManager.navigator("menu.MainInitialMenu");
            return;
        }

        ContextStore.setCurrentUser(newUser);
        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        BankAccountModel bankAccount = bankAccountRepo.read(newUser.getId());
        ContextStore.setCurrentAccount(bankAccount);
        viewManager.navigator("menu.BankAppMainMenu");

    }
}



