import View.*;

public class Main {

    public static void main(String[] args) {

        ViewManager viewManager = ViewManager.getViewManager();

        viewManager.registerView(new MainInitialMenu());
        viewManager.registerView(new MainInitialLoginMenu());
        viewManager.registerView(new MainInitialCreateMenu());
        viewManager.registerView(new BankAppMainMenu());
        viewManager.registerView(new DepositCheckingMenu());
        viewManager.registerView(new DepositSavingMenu());
        viewManager.registerView(new WithdrawCheckingMenu());
        viewManager.registerView(new WithdrawSavingMenu());
        viewManager.registerView(new CheckBalanceMenu());

        viewManager.navigator("menu.MainInitialMenu");
        while (viewManager.isRunning()) {
            viewManager.render();
        }

    }
}