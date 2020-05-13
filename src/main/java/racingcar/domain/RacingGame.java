package racingcar.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private GameInfo gameInfo;
    private ParticipateCars participateCars;

    public RacingGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        this.participateCars = new ParticipateCars(gameInfo.getNumberOfCar());
    }

    public GameResult startGame() {
        int numberOfPhase = gameInfo.getNumberOfPhase();
        GameResult gameResult = new GameResult(numberOfPhase);

        for (int i = 0; i < numberOfPhase; i++) {
            List<Integer> raceResult = participateCars.tryMove(new Random());
            gameResult.addPhaseResult(new PhaseResult(raceResult));
        }

        return gameResult;
    }
}
