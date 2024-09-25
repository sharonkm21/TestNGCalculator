package DesignPatternHomeTasks.Five;

public class HomeTaskFive
{
    public static void main(String[] args) {
        // Example 1: Customer builds a Bicycle with Gears and Carrier
        Bicycle bicycle1 = new BicycleBuilder()
                .addGears()
                .addCarrier()
                .build();

        System.out.println("Customer 1's Bicycle: " + bicycle1);

        // Example 2: Customer builds a Bicycle with Double Seats and Double Stands
        Bicycle bicycle2 = new BicycleBuilder()
                .addDoubleSeats()
                .addDoubleStands()
                .build();

        System.out.println("Customer 2's Bicycle: " + bicycle2);

        // Example 3: Customer builds a Bicycle with all options
        Bicycle bicycle3 = new BicycleBuilder()
                .addGears()
                .addDoubleSeats()
                .addDoubleStands()
                .addCarrier()
                .build();

        System.out.println("Customer 3's Bicycle: " + bicycle3);

        // Example 4: Customer builds a Bicycle with no extra features
        Bicycle bicycle4 = new BicycleBuilder().build();

        System.out.println("Customer 4's Bicycle: " + bicycle4);
    }
}
