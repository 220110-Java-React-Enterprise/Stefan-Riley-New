package View;

import Utils.CustomArrayList;

import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private final Scanner scanner;
    CustomArrayList<View> viewList;
    View nextView;
    private boolean running;

    private ViewManager() {
        //SETTING UP THE VALUES AND REFERENCES
        running = true;
        scanner = new Scanner(System.in);
//        viewList = new LinkedList<>();
        viewList = new CustomArrayList<>();

    }

    public static ViewManager getViewManager() {
        if (viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;

    }

    public void navigator(String destination) {
        for (int i = 0; i < viewList.size(); i++) {
            if (viewList.get(i).viewName.equals(destination)) {
                nextView = viewList.get(i);
            }
        }
    }

    public void registerView(View view) {
        viewList.add(view);
    }

    public void render() {
        nextView.renderView();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

}