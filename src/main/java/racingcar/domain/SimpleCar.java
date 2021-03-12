package racingcar.domain;

public class SimpleCar implements Car {
    private Name name;
    private Distance distance;

    public SimpleCar(String name) {
        this.name = new Name(name);
        distance = new Distance();
    }

    @Override
    public Distance forward(MovementCondition movementCondition) {
        if (movementCondition.isMovable()) {
            distance = distance.increase();
        }
        return distance;
    }

    @Override
    public Distance getDistance() {
        return distance;
    }

    @Override
    public Name getName() {
        return name;
    }
}
