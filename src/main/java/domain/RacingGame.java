package domain;

import service.impl.RandomMoveRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCars racingCars;
    private final Integer roundNumber;

    private RacingGame(RacingCars racingCars, Integer roundNumber) {
        this.racingCars = racingCars;
        this.roundNumber = roundNumber;
    }

    public static RacingGame create(String[] carNames, Integer roundNumber) {
        validate(carNames, roundNumber);
        List<RacingCar> cars = Arrays.stream(carNames)
                .map(carName -> RacingCar.newInstance(carName.trim(), new RandomMoveRule()))
                .collect(Collectors.toList());

        return new RacingGame(new RacingCars(cars), roundNumber);
    }

    private static void validate(String[] carNames, Integer roundNumber) {
        if (carNames == null || carNames.length <= 0) {
            throw new IllegalArgumentException("car number must be greater than zero.");
        }

        if (roundNumber == null || roundNumber <= 0) {
            throw new IllegalArgumentException("round number must be greater than zero.");
        }
    }

    public RacingGameResult start() {
        List<RacingRound> racingRounds = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            racingRounds.add(racingCars.moveAll());
        }
        return new RacingGameResult(racingRounds);
    }
}
