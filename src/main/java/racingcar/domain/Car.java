package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition position;

    public Car(final String name) {
        this(new CarName(name), new CarPosition(0));
    }

    public Car(final String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(final CarName name, final CarPosition position) {
        this.carName = name;
        this.position = position;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public CarPosition getCarPosition() {
        return this.position;
    }

    public boolean isWinner(CarPosition maxPosition) {
        return this.position.equals(maxPosition);
    }

    public CarPosition maxPosition(CarPosition maxPosition) {
        return this.position.maxPosition(maxPosition);
    }
}
