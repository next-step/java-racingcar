package racingcar.module;

import racingcar.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingRound {
    private Map<Integer, List<Car>> roundResult;

    public RacingRound() {
        this.roundResult = new HashMap<>();
    }

    public void insertResult(List<Car> cars, int round) {
        roundResult.put(round, cars);
    }

    public Map<Integer, List<Car>> getRoundResult() {
        return Collections.unmodifiableMap(roundResult);
    }

}
