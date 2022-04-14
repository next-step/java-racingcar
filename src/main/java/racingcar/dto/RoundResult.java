package racingcar.dto;

import racingcar.PositiveInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RoundResult {
    private final List<PositiveInteger> states;

    private RoundResult(List<PositiveInteger> states) {
        validate(states);
        this.states = new ArrayList<>(states);
    }

    private void validate(List<PositiveInteger> states) {
        Objects.requireNonNull(states, "전달된 리스트가 올바르지 않습니다 : RoundResult is null");

        if (states.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : RoundResult is empty");
        }
    }

    public List<PositiveInteger> getStates() {
        return Collections.unmodifiableList(states);
    }

    public static RoundResult of(List<PositiveInteger> states) {
        return new RoundResult(states);
    }
}
