package DesignPatternHomeTasks.Five;

public class Bicycle
{
    private final boolean hasGears;
    private final boolean hasDoubleStands;
    private final boolean hasDoubleSeats;
    private final boolean hasCarrier;

    // Private constructor to enforce the use of the builder for object creation
    public Bicycle(BicycleBuilder builder) {
        this.hasGears = builder.hasGears;
        this.hasDoubleStands = builder.hasDoubleStands;
        this.hasDoubleSeats = builder.hasDoubleSeats;
        this.hasCarrier = builder.hasCarrier;
    }

    // Getters for the Bicycle configuration
    public boolean hasGears() {
        return hasGears;
    }

    public boolean hasDoubleStands() {
        return hasDoubleStands;
    }

    public boolean hasDoubleSeats() {
        return hasDoubleSeats;
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "hasGears=" + hasGears +
                ", hasDoubleStands=" + hasDoubleStands +
                ", hasDoubleSeats=" + hasDoubleSeats +
                ", hasCarrier=" + hasCarrier +
                '}';
    }
}
