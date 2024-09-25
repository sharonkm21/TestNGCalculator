package DesignPatternHomeTasks.Four;

public class ContactFormWidget extends WidgetDecorator {

    public ContactFormWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + 30; // Contact form adds 30 to the rank
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Contact Form";
    }
}
