package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int rounds;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void startGame() {
        for (int round = 0; round < rounds; round++) {
            playRound();
        }
    }

    public void playRound() {
        cars.moveAll();
    }
}
