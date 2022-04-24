package racingcar.model;

import java.util.Objects;

public final class Car {
    private static final Distance INIT_DISTANCE = Distance.ZERO;
    private static final Distance MOVE_DISTANCE = Distance.ONE;

    private final CarName name;
    private final Distance distance;

    public Car(CarName name) {
        this(name, INIT_DISTANCE);
    }

    public Car(CarName name, Distance distance) {
        validate(name, distance);
        this.name = name;
        this.distance = distance;
    }

    private void validate(CarName name, Distance distance) {
        Objects.requireNonNull(name, "Car 생성시 전달된 carName 이 올바르지 않습니다. : name is null");
        Objects.requireNonNull(distance, "Car 생성시 전달된 distance 가 올바르지 않습니다. : distance is null");
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(name, Distance.add(distance, MOVE_DISTANCE));
        }
        return new Car(name, new Distance(distance.value()));
    }

    public boolean isSameDistance(Distance distance) {
        return this.distance.equals(distance);
    }

    public CarName name() {
        return name;
    }

    public Distance distance() {
        return distance;
    }
}
