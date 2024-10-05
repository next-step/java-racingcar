package study.racing.car;

public class Car {

    private Position position;
    private final CarName name;

    public Car(String name, int position) {
        this(new CarName(name), new Position(position));
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position = this.position.increase();
    }

    public Position getCurrentPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }
}
