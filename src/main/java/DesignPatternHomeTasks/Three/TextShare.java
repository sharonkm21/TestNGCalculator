package DesignPatternHomeTasks.Three;

public class TextShare implements ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing photo via text...");
    }
}
