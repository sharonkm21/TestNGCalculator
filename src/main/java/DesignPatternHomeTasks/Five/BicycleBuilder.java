package DesignPatternHomeTasks.Five;

public class BicycleBuilder
{
    // Optional components with default values
    boolean hasGears = false;
    boolean hasDoubleStands = false;
    boolean hasDoubleSeats = false;
    boolean hasCarrier = false;

    // Methods for setting each optional feature
    public BicycleBuilder addGears() {
        this.hasGears = true;
        return this;
    }

    public BicycleBuilder addDoubleStands() {
        this.hasDoubleStands = true;
        return this;
    }

    public BicycleBuilder addDoubleSeats() {
        this.hasDoubleSeats = true;
        return this;
    }

    public BicycleBuilder addCarrier() {
        this.hasCarrier = true;
        return this;
    }

    // Final method to construct the immutable Bicycle object
    public Bicycle build() {
        return new Bicycle(this);
    }

}
