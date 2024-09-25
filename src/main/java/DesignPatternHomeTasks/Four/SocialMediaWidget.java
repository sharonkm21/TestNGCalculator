package DesignPatternHomeTasks.Four;

public class SocialMediaWidget extends WidgetDecorator {

    public SocialMediaWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + 40; // Social media adds 40 to the rank
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Social Media Integration";
    }
}
