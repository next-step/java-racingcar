package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int rounds;
    private final StringBuilder gameResult;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.gameResult = new StringBuilder();
    }

    public void startGame() {
        for (int round = 0; round < rounds; round++) {
            playRound();
        }
    }

    public String result() {
        return gameResult.toString();
    }

    private void playRound() {
        cars.moveAll();
        gameResult.append(cars.status()).append("\n");
    }
}
