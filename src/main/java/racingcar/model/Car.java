package racingcar.model;

import java.util.Objects;

public final class Car {
    private final Distance state;

    public Car() {
        this.state = Distance.ZERO;
    }

    public Car(Distance state) {
        validate(state);
        this.state = state;
    }

    private void validate(Distance state) {
        Objects.requireNonNull(state, "Car 생성시 전달된 state 가 올바르지 않습니다. : state is null");
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(Distance.add(state, Distance.MOVE_STATE));
        }
        return new Car(new Distance(state.value()));
    }

    public Distance state() {
        return state;
    }
}
