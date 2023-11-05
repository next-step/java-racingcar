package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Round> rounds;
    private final Cars cars;

    public RacingGame(final int racingCarNumber, final int tryCountNumber) {
        this.cars = new Cars(CarFactory.createCars(racingCarNumber));
        this.rounds = new ArrayList<>();

        for (int i = 0; i < tryCountNumber; i++) {
            rounds.add(new Round(cars));
        }
    }

    public void play() {
        for (Round round : rounds) {
            round.playRound(cars);
            round.printRoundResults();
        }
    }

}
