package racingcar.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private int numberOfPhase;
    private ParticipateCars participateCars;

    public RacingGame(int numberOfPhase, int numberOfCar) {
        this.numberOfPhase = numberOfPhase;
        this.participateCars = new ParticipateCars(numberOfCar);
    }

    public GameResult startGame() {
        GameResult gameResult = new GameResult(numberOfPhase);

        for (int i = 0; i < numberOfPhase; i++) {
            List<Integer> raceResult = participateCars.tryMove(new Random());
            gameResult.addPhaseResult(new PhaseResult(raceResult));
        }

        return gameResult;
    }
}
