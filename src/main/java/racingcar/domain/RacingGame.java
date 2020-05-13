package racingcar.domain;

import racingcar.domain.car.NumberGenerator;
import racingcar.domain.car.ParticipateCars;

import java.util.List;

public class RacingGame {
    private GameInfo gameInfo;
    private ParticipateCars participateCars;

    public RacingGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        this.participateCars = new ParticipateCars(gameInfo.getNumberOfCar());
    }

    public GameResult startGame(NumberGenerator numberGenerator) {
        int numberOfPhase = gameInfo.getNumberOfPhase();
        GameResult gameResult = new GameResult(numberOfPhase);

        for (int i = 0; i < numberOfPhase; i++) {
            List<Integer> raceResult = participateCars.tryMove(numberGenerator);
            gameResult.addPhaseResult(new PhaseResult(raceResult));
        }

        return gameResult;
    }
}
