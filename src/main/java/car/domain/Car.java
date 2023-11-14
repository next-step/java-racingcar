package car.domain;

public class Car {
    private static final int MIN_RANDOM_NUMBER = 4;

    private final Position position;
    private final Name carName;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String carName, int position) {
        this.carName = new Name(carName);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_RANDOM_NUMBER) {
            this.position.increase();
        }
    }

    public String getCarName() {
        return this.carName.carName();
    }

    public int getCarPosition() {
        return this.position.carPosition();
    }

    public int compareCarPosition(int number) {
        return this.position.compareCarPosition(number);
    }

    public boolean isSameMax(int max) {
        return this.position.isSameMax(max);
    }

}
