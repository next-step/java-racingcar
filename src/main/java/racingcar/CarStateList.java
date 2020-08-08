package racingcar;

import java.util.List;

public class CarStateList {
    private final List<CarState> states;

    private CarStateList(List<CarState> states) {
        this.states = states;
    }

    public List<CarState> getStates() {
        return this.states;
    }

    public static CarStateList makeCarStateList(List<CarState> states) {
        return new CarStateList(states);
    }
}
