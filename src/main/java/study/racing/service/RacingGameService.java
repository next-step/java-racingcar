package study.racing.service;

import java.util.ArrayList;
import java.util.List;

import study.racing.exception.InvalidInputCountException;
import study.racing.model.Name;
import study.racing.model.car.RacingCars;
import study.racing.model.result.GameResults;
import study.racing.model.result.RoundResult;
import study.racing.model.rule.Rule;

public class RacingGameService {

    public static final String CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE = "carCount and tryCount must be positive";
    public static final int MIN_COUNT = 0;

    private final Rule rule;

    public RacingGameService(Rule rule) {
        this.rule = rule;
    }

    public GameResults race(List<Name> carNames, int tryCount) {
        validateOrThrow(carNames.size(), tryCount);

        RacingCars racingCars = RacingCars.from(carNames);
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingCars.raceAll(rule);
            RoundResult roundResult = new RoundResult(racingCars);
            roundResults.add(roundResult);
        }
        return new GameResults(roundResults);
    }

    private void validateOrThrow(int carCount, int tryCount) {
        if (carCount <= MIN_COUNT || tryCount <= MIN_COUNT) {
            throw new InvalidInputCountException(CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE);
        }
    }
}
