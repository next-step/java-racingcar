package racingcar.dto;

import racingcar.model.CarName;
import racingcar.model.Distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RoundResult {
    private final List<CarName> carNames;
    private final List<Distance> states;
    private final int carsCount;

    private RoundResult(List<CarName> carNames, List<Distance> states) {
        validate(carNames, states);
        this.carNames = new ArrayList<>(carNames);
        this.states = new ArrayList<>(states);
        this.carsCount = carNames.size();
    }

    private void validate(List<CarName> carNames, List<Distance> states) {
        Objects.requireNonNull(carNames, "RoundResult 에 전달된 리스트가 올바르지 않습니다 : carNames is null");
        Objects.requireNonNull(states, "RoundResult 에 전달된 리스트가 올바르지 않습니다 : states is null");

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("RoundResult 에 전달된 리스트가 올바르지 않습니다 : carNames is empty");
        }
        if (states.isEmpty()) {
            throw new IllegalArgumentException("RoundResult 에 전달된 리스트가 올바르지 않습니다 : states is empty");
        }
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public List<Distance> getStates() {
        return Collections.unmodifiableList(states);
    }

    public int getCarsCount() {
        return carsCount;
    }

    public static RoundResult of(List<CarName> carNames, List<Distance> states) {
        return new RoundResult(carNames, states);
    }
}
