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
        this.name = new CarName(car.name.getName());
        this.position = new Position(car.position.getPosition());
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position getPosition() { // todo 안쓸 수 없을까?
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }

    private void move() {
        this.position.forward();
    }

    public Position tryForward(RandomMovableStrategy randomMovableStrategy) {
        if (this.isForward(randomMovableStrategy.getForwardPosition())) this.move();
        return this.position;
    }

    private boolean isForward(int condition) {
        return condition >= THRESHOLD;
    }
}
