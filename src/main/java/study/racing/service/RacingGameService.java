package study.racing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import study.racing.model.Result;
import study.racing.model.car.RacingCars;
import study.racing.model.rule.Rule;

public class RacingGameService {

    public static final String CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE = "carCount and tryCount must be positive";

    private final Rule rule;

    public RacingGameService(Rule rule) {
        this.rule = rule;
    }

    public List<Result> race(List<String> carNames, int tryCount) {
        validateOrThrow(carNames.size(), tryCount);

        List<Result> results = new ArrayList<>();
        RacingCars racingCars = new RacingCars(carNames);
        for (int i = 0; i < tryCount; i++) {
            racingCars.raceAll(rule);
            results.add(new Result(racingCars.result()));
        }
        return Collections.unmodifiableList(results);
    }

    private void validateOrThrow(int carCount, int tryCount) {
        if (carCount <= 0 || tryCount <= 0) {
            throw new RuntimeException(CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE);
        }
    }
}
