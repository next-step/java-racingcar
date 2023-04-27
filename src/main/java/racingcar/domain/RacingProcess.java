package racingcar.domain;

import racingcar.model.Cars;
import racingcar.model.Constant;
import racingcar.model.RoundScores;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.model.Constant.*;

public class RacingProcess {
    private final String carName;
    private final int periodCount;
    private final Map<Integer, RoundScores> roundScoresMap = new HashMap<>();

    public RacingProcess(String carNames, int periodCount) {
        carNameValidation(carNames);
        countValidation(periodCount);

        this.carName = carNames;
        this.periodCount = periodCount;
    }

    public void racingStart() {
        Cars cars = Cars.generateCars(carName);

        iterateRacing(cars);
    }

    public Map<Integer, RoundScores> getScores() {
        return Collections.unmodifiableMap(roundScoresMap);
    }

    public List<String> getWinner() {
        RoundScores roundScores = roundScoresMap.get(roundScoresMap.size() - 1);
        return roundScores.getWinner();
    }

    private void iterateRacing(Cars cars) {
        initRacing(cars);
        for (int i = 1; i < periodCount; i++) {
            cars.checkForwardConditionAndGo();
            roundScoresMap.put(i, cars.getRoundResult());
        }
    }

    private void initRacing(Cars cars) {
        roundScoresMap.put(IntegerConstant.ZERO, cars.getRoundResult());
    }

    private void countValidation(int count) {
        if (count < 0) {
            throw new RuntimeException(Exceptions.DO_NOT_INPUT_NEGATIVE);
        }
    }

    private void carNameValidation(String carNames) {
        if (carNames == null || "".equals(carNames)) {
            throw new IllegalArgumentException(Exceptions.CAR_NAME_MUST_NOT_BE_NULL);
        }
    }

}
