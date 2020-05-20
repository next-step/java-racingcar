package step3.controller;

import step3.domain.GameRule;
import step3.domain.RacingCar;
import step3.domain.RacingCars;
import step3.factory.MoveStrategyFactory;
import step3.exception.RoundNotFoundException;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGameController {

    private final GameRule gameRule;
    private final int gameRound;
    private final List<RacingCar> racingCars;

    private int progressRound;

    private RacingGameController(GameRule gameRule, String[] carNames, int gameRound) {
        this.gameRule = gameRule;
        this.gameRound = gameRound;
        this.racingCars = Arrays.stream(carNames)
                .map(RacingCar::create)
                .collect(toList());
    }

    public static RacingGameController newInstance(GameRule gameRule, String[] carNames, int gameRound) {
        return new RacingGameController(gameRule, carNames, gameRound);
    }

    public void nextRound() {
        if (!this.hasNextRound()) {
            throw new RoundNotFoundException();
        }

        this.progressRound++;
        this.racingCars.forEach(racingCar -> racingCar.move(MoveStrategyFactory.getInstance(this.gameRule)));
    }

    public boolean hasNextRound() {
        return this.progressRound < this.gameRound;
    }

    public RacingCars getRacingCars() {
        return new RacingCars(this.racingCars);
    }
}
