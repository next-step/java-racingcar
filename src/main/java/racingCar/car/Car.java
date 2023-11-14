package racingCar.car;

import racingCar.util.NumberSupplier;

public class Car {
    public int distance;
    public String name;
    private final NumberSupplier numberSupplier;

    public Car(int distance, NumberSupplier numberSupplier) {
        this.distance = distance;
        this.numberSupplier = numberSupplier;
    }

    public Car(int distance, NumberSupplier numberSupplier, String name) {
        this.distance = distance;
        this.numberSupplier = numberSupplier;
        this.name = name;
    }

    public void move() {
        int randomNumber = numberSupplier.get();
        if (randomNumber > 3) {
            distance++;
        }
    }
}
