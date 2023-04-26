package racingcar.domain;

public class Car {
    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance();
    }

    public void move(int number) {
        if (number >= 4) {
            distance.increase();
        }
    }

    public int distanceDriven() {
        return distance.getDistance();
    }

    public String name() {
        return carName.getName();
    }
}
