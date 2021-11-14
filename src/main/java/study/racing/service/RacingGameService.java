package study.racing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.model.GameResults;
import study.racing.model.RoundResult;
import study.racing.model.car.Car;
import study.racing.model.car.RacingCars;
import study.racing.model.rule.Rule;

public class RacingGameService {

    public static final String CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE = "carCount and tryCount must be positive";

    private final Rule rule;

    public RacingGameService(Rule rule) {
        this.rule = rule;
    }

    public GameResults race(List<String> carNames, int tryCount) {
        validateOrThrow(carNames.size(), tryCount);

        List<Car> cars = createCars(carNames);
        RacingCars racingCars = new RacingCars(cars);
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingCars.raceAll(rule);
            roundResults.add(new RoundResult(racingCars));
        }
        return new GameResults(roundResults);
    }

    private void validateOrThrow(int carCount, int tryCount) {
        if (carCount <= 0 || tryCount <= 0) {
            throw new RuntimeException(CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE);
        }
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                       .map(Car::new)
                       .collect(Collectors.toList());
    }
}
