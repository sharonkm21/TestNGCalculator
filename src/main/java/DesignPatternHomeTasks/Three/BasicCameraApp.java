package DesignPatternHomeTasks.Three;

public class BasicCameraApp extends PhoneCameraApp {

    public BasicCameraApp(ShareStrategy shareStrategy) {
        super(shareStrategy);
    }

    @Override
    public void editPhoto() {
        System.out.println("Editing photo with basic editor...");
    }
}