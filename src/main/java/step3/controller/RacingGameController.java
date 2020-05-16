package step3.controller;

import step3.domain.RacingCar;
import step3.domain.RandomMoveFactory;
import step3.exception.RoundNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private final int gameRound;
    private final List<RacingCar> racingCars;

    private int progressRound;

    private RacingGameController(String[] carNames, int gameRound) {
        this.gameRound = gameRound;
        this.racingCars = Arrays.stream(carNames)
                .map(RacingCar::create)
                .collect(Collectors.toList());
    }

    public static RacingGameController start(String[] carNames, int gameRound) {
        return new RacingGameController(carNames, gameRound);
    }

    public void nextRound() {
        if (!this.hasNextRound()) {
            throw new RoundNotFoundException();
        }

        this.progressRound++;
        this.racingCars.forEach(racingCar -> racingCar.move(RandomMoveFactory.getInstance()));
    }

    public boolean hasNextRound() {
        return this.progressRound < this.gameRound;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
