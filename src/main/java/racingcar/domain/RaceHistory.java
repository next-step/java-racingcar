package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {

    public static final String SEPARATE_ROUNDS = "\n\n";
    private final List<String> states;

    public RaceHistory() {
        states = new ArrayList<>();
    }

    public RaceHistory(List<String> states) {
        this.states = states;
    }

    public RaceHistory update(Cars cars) {
        states.add(cars.toString());
        return new RaceHistory(states);
    }

    @Override
    public String toString() {
        return String.join(SEPARATE_ROUNDS, states);
    }
}
