package DesignPatternHomeTasks.Three;

public abstract class PhoneCameraApp {
    private ShareStrategy shareStrategy;

    // Constructor to set initial share strategy
    public PhoneCameraApp(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    // General method to take a photo
    public void takePhoto() {
        System.out.println("Taking a photo...");
    }

    // Abstract method to be implemented by specific apps for editing
    public abstract void editPhoto();

    // General method to save the photo
    public void savePhoto() {
        System.out.println("Saving the photo...");
    }

    // Method to perform sharing using the share strategy
    public void sharePhoto() {
        shareStrategy.share();
    }

    // Method to set a new sharing strategy dynamically
    public void setShareStrategy(ShareStrategy newStrategy) {
        this.shareStrategy = newStrategy;
    }
}