package View;

import Persistance.BankAccountModel;
import Persistance.ClientInformationModel;
import Repo.BankAccountRepo;
import Repo.ClientInformationRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainInitialCreateMenu extends View {

    public MainInitialCreateMenu() {
        viewName = "menu.MainInitialCreateMenu";
        viewManager = ViewManager.getViewManager();
    }

    public void renderView() {

        //CREATING CLIENT INFORMATION

        System.out.println("************* THANKS FOR YOUR INTEREST IN REGISTERING FOR AN ACCOUNT ************* ");
        System.out.println("Setting up you account now. Let's get you signed up Today!");
        System.out.println("Let's start with some quick details");
        System.out.println("***********************************************");

        //PART 1 OF THE CREATING AN ACCOUNT
        System.out.println("Enter your first name : ");
        String firstName = (viewManager.getScanner().nextLine());
        System.out.println(firstName);

        System.out.println("-----------------------------------------------");
        System.out.println("Enter your last name : ");
        String lastName = viewManager.getScanner().nextLine();
        System.out.println(lastName);



        String email = "";
        String regex = "^([0-9a-zA-Z.]+@[0-9a-zA-Z]+[.][a-zA-Z]+){1,40}$";
        Pattern pattern = Pattern.compile(regex);
        while(true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Enter your email: ");
            email = viewManager.getScanner().nextLine();
            Matcher matcher = pattern.matcher(email); //CREATED THE INSTANCE FOR THE MATCHER
            if(matcher.matches()) {
                System.out.println("Email Correctly formatted" + matcher);
                break;
            } else {
                System.out.println("Email Incorrectly formatted");
            }
        }

        System.out.println("***********************************************");
        System.out.println("Thanks " + firstName + " " + lastName);
        System.out.println("We are almost finished. Just a bits of information more....");

        System.out.println("-----------------------------------------------");
        System.out.println("Create a username :");
        String username = viewManager.getScanner().nextLine();
        System.out.println(username);
        System.out.println("-----------------------------------------------");

        System.out.println("Make a password :");
        String password = viewManager.getScanner().nextLine();
        System.out.println(password);

        System.out.println("-----------------------------------------------");
        System.out.println("Country : (Example US) ");
        String country = viewManager.getScanner().nextLine();
        System.out.println(country);

        System.out.println("-----------------------------------------------");
        System.out.println("Street Address : ");
        String addressStreet = viewManager.getScanner().nextLine();
        System.out.println(addressStreet);

        System.out.println("-----------------------------------------------");

        System.out.println("State: For example : LA ");
        String addressState = viewManager.getScanner().nextLine();
        System.out.println(addressState);

        System.out.println("-----------------------------------------------");

        System.out.println("Zipcode : ");
        Integer addressZipCode = viewManager.getScanner().nextInt();
        viewManager.getScanner().nextLine();
        System.out.println(addressZipCode);

        System.out.println("-----------------------------------------------");

        System.out.println("Thank for filling out the form. Processing the information now");
        System.out.println("Review the following information: ");

        System.out.println(firstName + " " + lastName);
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(country);
        System.out.println(addressStreet);
        System.out.println(addressState);
        System.out.println(addressZipCode);

        System.out.println("You account has been created! ");
        System.out.println("***********************************************");
        System.out.println("\n");

        //CREATING THE INFORMATION TO THE DATABASE

        ClientInformationModel user = new ClientInformationModel(username, password, firstName, lastName, email, country, addressStreet, addressState, addressZipCode);
        ClientInformationRepo repo = new ClientInformationRepo();
        repo.create(user);

        //AUTHENTICATOR

        user = repo.authenticate(user.getUsername(), user.getPassword());

        //CREATING THE DEFAULT VALUES TO THE THE LINKED BANK ACCOUNT DATABASE

        BankAccountModel bankUser = new BankAccountModel(0, 0, user.getId());
        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        bankAccountRepo.create(bankUser);

        viewManager.navigator("menu.BankAppMainMenu");

    }

}

