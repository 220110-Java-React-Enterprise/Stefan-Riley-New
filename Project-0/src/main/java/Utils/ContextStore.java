package Utils;

import Persistance.BankAccountModel;
import Persistance.ClientInformationModel;

public class ContextStore {

    private static ClientInformationModel currentUser;
    private static BankAccountModel currentAccount;

    public static ClientInformationModel getCurrentUser() {

        return currentUser;
    }

    public static void setCurrentUser(ClientInformationModel user) {

        currentUser = user;
    }

    public static BankAccountModel getCurrentAccount() {

        return currentAccount;
    }

    public static void setCurrentAccount(BankAccountModel currentAccount) {
        ContextStore.currentAccount = currentAccount;
    }


}
