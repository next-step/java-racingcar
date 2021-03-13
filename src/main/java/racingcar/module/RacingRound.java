package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class RacingRound {
    private Map<Integer, List<Integer>> roundResult;

    public RacingRound() {
        this.roundResult = new HashMap<>();
    }

    public void insertResult(Cars cars, int round) {
        roundResult.put(round, cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public Map<Integer, List<Integer>> getRoundResult() {
        return Collections.unmodifiableMap(roundResult);
    }
}
