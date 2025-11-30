package domain;

public class Car {
    private CarName carName;
    private Position position;

    public Car(String carName, int position) {
        this(new CarName(carName), new Position(position));
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }
}
