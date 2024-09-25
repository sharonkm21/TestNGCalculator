package DesignPatternHomeTasks.Three;

public class CameraPlusApp extends PhoneCameraApp {

    public CameraPlusApp(ShareStrategy shareStrategy) {
        super(shareStrategy);
    }

    @Override
    public void editPhoto() {
        System.out.println("Editing photo with advanced editor...");
    }
}