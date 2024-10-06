package race.car;

import race.race.RandomNumber;

public class Car {

    private static final int FORWARD_NUMBER = 4;

    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position(1);
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void forward(RandomNumber randomNumber) {
        if (randomNumber.isBigOrEqual(FORWARD_NUMBER)) {
            this.position = position.increase();
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int compareWithMaxPosition(int maxPosition) {
        return this.position.compareWithMaxPosition(maxPosition);
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getCarName() {
        return carName.getValue();
    }
}
