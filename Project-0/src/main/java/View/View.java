package View;

public abstract class View {

    //SET THE REST OF THE VIEW MENU VARIABLES
    protected String viewName;
    protected ViewManager viewManager;

    public String getViewName() { //AN ALREADY PREMADE METHOD
        return viewName;
    }

    public abstract void renderView();

}