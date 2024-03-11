package race;

public class Car {
    public Car(int numberOfCars) {
    }

    public String go(int count) {
        String mileage = "-";
        for (int i = 1; i < count; i++) {
            mileage += "-";
        }
        return mileage;
    }
}
