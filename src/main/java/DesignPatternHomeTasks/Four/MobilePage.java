package DesignPatternHomeTasks.Four;

public class MobilePage implements WebPage {
    @Override
    public int getRank() {
        return 50; // Base rank for a mobile page
    }

    @Override
    public String getDescription() {
        return "Mobile Page";
    }
}
