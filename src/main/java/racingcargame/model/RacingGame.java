package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;
    private final int roundNumber;
    private final List<History> histories = new ArrayList<>();

    public RacingGame(RacingCars racingCars, int roundNumber) {
        this.racingCars = racingCars;
        this.roundNumber = roundNumber;
        playGame();
    }

    public void playGame() {
        for (int i = 0; i < roundNumber; i++) {
            histories.add(racingCars.playRound());
        }
    }

    public List<History> getHistories() {
        return histories;
    }
}
