package racingcar;

public class Car {
    private final PositiveInteger state;

    public Car() {
        this.state = PositiveInteger.ZERO;
    }

    public Car(int state) {
        this.state = new PositiveInteger(state);
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(state.value()+1);
        }
        return new Car(state.value());
    }
    public int state() {
        return state.value();
    }
}
