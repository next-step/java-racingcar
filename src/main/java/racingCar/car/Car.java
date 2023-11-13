package racingCar.car;

import racingCar.util.NumberSupplier;

public class Car {
    public int distance;
    private final NumberSupplier numberSupplier;

    public Car(int distance, NumberSupplier numberSupplier) {
        this.distance = distance;
        this.numberSupplier = numberSupplier;
    }

    public void move() {
        int randomNumber = numberSupplier.get();
        if (randomNumber > 3) {
            distance++;
        }
    }
}
