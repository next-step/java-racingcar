package racingcar.dto;

import racingcar.model.Distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RoundResult {
    private final List<Distance> states;

    private RoundResult(List<Distance> states) {
        validate(states);
        this.states = new ArrayList<>(states);
    }

    private void validate(List<Distance> states) {
        Objects.requireNonNull(states, "전달된 리스트가 올바르지 않습니다 : RoundResult is null");

        if (states.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : RoundResult is empty");
        }
    }

    public List<Distance> getStates() {
        return Collections.unmodifiableList(states);
    }

    public static RoundResult of(List<Distance> states) {
        return new RoundResult(states);
    }
}
