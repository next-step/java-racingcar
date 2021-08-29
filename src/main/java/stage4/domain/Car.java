package stage4.domain;

public class Car {
    private final static int THRESHOLD = 4;
    private final CarName name;
    private final Position position;


    public Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(Car car) {
        this.name = new CarName(car.name);
        this.position = new Position(car.position);
    }


    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }


    public Position tryForward(MovableStrategy randomMovableStrategy) {
        if (this.isForward(randomMovableStrategy.getForwardPosition())) this.move();
        return this.position;
    }

    private void move() {
        this.position.forward();
    }

    private boolean isForward(int condition) {
        return condition >= THRESHOLD;
    }

    public boolean isPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    private boolean isGreaterThan(Position max) {
        return this.position.greaterThan(max);
    }

    public Position getMaxPosition(Position max) {
        if (isGreaterThan(max)) {
            max = this.position;
        }
        return max;
    }
}
