package racingcar;

public class Car {
    private final CarName carName;
    private int distance = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public int distanceDriven() {
        return distance;
    }

    public String name() {
        return carName.getName();
    }
}
