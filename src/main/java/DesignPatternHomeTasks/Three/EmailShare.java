package DesignPatternHomeTasks.Three;

public class EmailShare implements ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing photo via email...");
    }
}