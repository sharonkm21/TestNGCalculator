package DesignPatternHomeTasks.Three;

public class HomeTask3Main
{
    public static void main(String[] args) {

        PhoneCameraApp basicApp = new BasicCameraApp(new TextShare());

        basicApp.takePhoto();
        basicApp.editPhoto();
        basicApp.savePhoto();
        basicApp.sharePhoto(); // Share via text

        // Change the share strategy to email
        basicApp.setShareStrategy(new EmailShare());
        basicApp.sharePhoto(); // Share via email

        PhoneCameraApp plusApp = new CameraPlusApp(new SocialMediaShare());

        plusApp.takePhoto();
        plusApp.editPhoto();
        plusApp.savePhoto();
        plusApp.sharePhoto(); // Share via social media
    }
}
