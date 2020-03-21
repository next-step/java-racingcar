package domain;

import service.impl.RandomMoveRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private RacingCars racingCars;
    private final Integer roundNumber;

    private RacingGame(RacingCars racingCars, Integer roundNumber) {
        this.racingCars = racingCars;
        this.roundNumber = roundNumber;
    }

    public static RacingGame create(Integer carNumber, Integer roundNumber) {
        validate(carNumber, roundNumber);
        List<RacingCar> cars = IntStream.range(0, carNumber)
                .mapToObj(i -> RacingCar.newInstance(new RandomMoveRule()))
                .collect(Collectors.toList());

        return new RacingGame(new RacingCars(cars), roundNumber);
    }

    private static void validate(Integer carNumber, Integer roundNumber) {
        if (carNumber == null || carNumber <= 0) {
            throw new IllegalArgumentException("car number must be greater than zero.");
        }

        if (roundNumber == null || roundNumber < 0) {
            throw new IllegalArgumentException("round number must be greater than zero.");
        }
    }

    public RacingGameResult start() {
        List<RacingRound> racingRounds = new ArrayList<>();
        for(int i = 0; i < roundNumber; i++) {
            racingRounds.add(racingCars.moveAll());
        }
        return new RacingGameResult(racingRounds);
    }
}
