package study.racing.service;

import java.util.ArrayList;
import java.util.List;

import study.racing.domain.Name;
import study.racing.domain.car.RacingCars;
import study.racing.domain.result.GameResults;
import study.racing.domain.result.Round;
import study.racing.domain.rule.Rule;
import study.racing.exception.InvalidInputCountException;

public class RacingGameService {

    private static final String CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE = "carCount and tryCount must be positive";
    private static final int MIN_COUNT = 0;

    private final Rule rule;

    public RacingGameService(Rule rule) {
        this.rule = rule;
    }

    public GameResults race(List<Name> carNames, int tryCount) {
        validateOrThrow(carNames.size(), tryCount);

        RacingCars racingCars = RacingCars.from(carNames);
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            RacingCars racedCars = racingCars.raceAll(rule);
            rounds.add(new Round(racedCars));
        }
        return new GameResults(rounds);
    }

    private void validateOrThrow(int carCount, int tryCount) {
        if (carCount <= MIN_COUNT || tryCount <= MIN_COUNT) {
            throw new InvalidInputCountException(CAR_COUNT_AND_TRY_COUNT_MUST_BE_POSITIVE);
        }
    }
}
