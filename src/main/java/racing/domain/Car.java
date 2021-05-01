package racing.domain;

public class Car {
    private CarName carName;
    private Distance distance;
    private MovableStrategy movableStrategy;

    private Car(CarName carName, MovableStrategy movableStrategy) {
        this.carName = carName;
        this.movableStrategy = movableStrategy;
        this.distance = Distance.zero;
    }

    public static Car of(String name, MovableStrategy movableStrategy) {
        return new Car(CarName.of(name), movableStrategy);
    }

    public void move() {
        if (movableStrategy.movable()) {
            this.distance = this.distance.plus(Distance.one);
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

    public int distance() {
        return this.distance.getDistance();
    }

    public String carName() {
        return this.carName.getName();
    }
}
