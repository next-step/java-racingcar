package racing.domain.car;

public class Car {

    private final CarPosition carPosition;

    public Car() {
        this(0);
    }

    public Car(CarPosition carPosition) {
        this.carPosition = carPosition;
    }

    public Car(int position) {
        this(new CarPosition(position));
    }

    public Car move() {
        return new Car(carPosition.advance());
    }

    public int position() {
        return carPosition.value();
    }
}
