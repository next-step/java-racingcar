package racingcar;

public class Car {
    private static final int MOVE_STATE = 1;
    private final PositiveInteger state;

    public Car() {
        this.state = PositiveInteger.ZERO;
    }

    public Car(PositiveInteger state) {
        this.state = state;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(PositiveInteger.add(state, new PositiveInteger(MOVE_STATE)));
        }
        return new Car(new PositiveInteger(state.value()));
    }

    public int state() {
        return state.value();
    }
}
