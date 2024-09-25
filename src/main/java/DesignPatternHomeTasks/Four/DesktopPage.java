package DesignPatternHomeTasks.Four;

public class DesktopPage implements WebPage {
    @Override
    public int getRank() {
        return 100; // Base rank for a desktop page
    }

    @Override
    public String getDescription() {
        return "Desktop Page";
    }
}
