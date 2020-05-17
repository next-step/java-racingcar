package step3.controller;

import step3.domain.RacingCar;
import step3.domain.RacingPosition;
import step3.domain.RacingWinner;
import step3.domain.RandomMoveFactory;
import step3.exception.RoundNotFinishedException;
import step3.exception.RoundNotFoundException;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingGameController {

    private final int gameRound;
    private final List<RacingCar> racingCars;

    private int progressRound;

    private RacingGameController(String[] carNames, int gameRound) {
        this.gameRound = gameRound;
        this.racingCars = Arrays.stream(carNames)
                .map(RacingCar::create)
                .collect(toList());
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

    public RacingPosition getRacingPosition() {
        return this.racingCars.stream()
                .collect(collectingAndThen(toList(), RacingPosition::new));
    }

    public RacingWinner getWinners() {
        if (this.hasNextRound()) {
            throw new RoundNotFinishedException();
        }

        int maxPosition = this.racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compare)
                .orElse(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(collectingAndThen(toList(), RacingWinner::new));
    }
}
