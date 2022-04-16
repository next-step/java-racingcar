package racingcar.model;

import java.util.Objects;

public final class Car {
    private final CarName name;
    private final Distance state;

    public Car(CarName name) {
        this.name = name;
        this.state = Distance.ZERO;
    }

    public Car(CarName name, Distance state) {
        validate(name, state);
        this.name = name;
        this.state = state;
    }

    private void validate(CarName name, Distance state) {
        Objects.requireNonNull(name, "Car 생성시 전달된 carName 이 올바르지 않습니다. : name is null");
        Objects.requireNonNull(state, "Car 생성시 전달된 state 가 올바르지 않습니다. : state is null");
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(name, Distance.add(state, Distance.MOVE_STATE));
        }
        return new Car(name, new Distance(state.value()));
    }

    public CarName name() {
        return name;
    }

    public Distance state() {
        return state;
    }
}
