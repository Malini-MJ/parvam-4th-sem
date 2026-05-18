public class PetrolCalculator {
    public static void main(String[] args) {
        // Mileage: 1 liter = 45 km
        int mileagePerLiter = 45;

        // Scenario 1: How far will 4 liters go?
        int litersAvailable = 4;
        int distanceCovered = litersAvailable * mileagePerLiter;

        // Scenario 2: How much petrol is needed for 200 km?
        int targetDistance = 200;
        double litersNeeded = (double) targetDistance / mileagePerLiter;

        // Output results
        System.out.println("Mileage per liter: " + mileagePerLiter + " km");
        System.out.println(  litersAvailable + " liters,  travel distance: " + distanceCovered + " km");
        System.out.println("target " + targetDistance + " km, required petrol: " + litersNeeded + " liters ");
    }
}
