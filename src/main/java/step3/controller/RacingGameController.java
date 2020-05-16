package step3.controller;

import step3.domain.RacingCar;
import step3.domain.RandomMoveFactory;
import step3.exception.RoundNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameController {

    private final int gameRound;
    private final List<RacingCar> racingCars;

    private int progressRound;
    private List<Integer> carPositions;

    private RacingGameController(int carCount, int gameRound) {
        this.gameRound = gameRound;
        this.racingCars = IntStream.range(0, carCount)
                .mapToObj(RacingCar::create)
                .collect(Collectors.toList());
    }

    public static RacingGameController start(int carCount, int gameRound) {
        return new RacingGameController(carCount, gameRound);
    }

    public void nextRound() {
        if (!this.hasNextRound()) {
            throw new RoundNotFoundException();
        }

        this.progressRound++;
        this.carPositions = this.racingCars.stream()
                .map(racingCar -> racingCar.move(RandomMoveFactory.getInstance()))
                .collect(Collectors.toList());
    }

    public boolean hasNextRound() {
        return this.progressRound < this.gameRound;
    }

    public List<Integer> getCarPosition() {
        return this.carPositions;
    }
}
