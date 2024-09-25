package DesignPatternHomeTasks.Four;

public class HomeTask_Four
{
    public static void main(String[] args) {
        WebPage mobilePage = new MobilePage();
        System.out.println(mobilePage.getDescription() + " has rank: " + mobilePage.getRank());

        mobilePage = new SearchBarWidget(mobilePage);
        System.out.println(mobilePage.getDescription() + " has rank: " + mobilePage.getRank());

        mobilePage = new ContactFormWidget(mobilePage);
        System.out.println(mobilePage.getDescription() + " has rank: " + mobilePage.getRank());

        WebPage desktopPage = new DesktopPage();
        System.out.println(desktopPage.getDescription() + " has rank: " + desktopPage.getRank());

        desktopPage = new SocialMediaWidget(desktopPage);
        System.out.println(desktopPage.getDescription() + " has rank: " + desktopPage.getRank());

        desktopPage = new SearchBarWidget(desktopPage);
        System.out.println(desktopPage.getDescription() + " has rank: " + desktopPage.getRank());
    }
}
