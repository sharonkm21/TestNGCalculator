package DesignPatternHomeTasks.Four;

public class SearchBarWidget extends WidgetDecorator {

    public SearchBarWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + 20; // Search bar adds 20 to the rank
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Search Bar";
    }
}
