package DesignPatternHomeTasks.Three;

public class SocialMediaShare implements ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing photo on social media...");
    }
}
