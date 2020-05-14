package racingcar.domain;

import racingcar.domain.car.ParticipateCars;
import racingcar.domain.car.Power;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int numberOfPhase;
    private ParticipateCars participateCars;
    private List<PhaseResult> phaseResults;

    public RacingGame(GameInfo gameInfo) {
        this.numberOfPhase = gameInfo.getNumberOfPhase();
        this.participateCars = new ParticipateCars(gameInfo.getNumberOfCar());
        this.phaseResults = new ArrayList<>();
    }

    public void startGame(Power power) {
        for (int phase = 0; phase < numberOfPhase; phase++) {
            PhaseResult phaseResult = new PhaseResult(participateCars.moveCars(power));
            phaseResults.add(phaseResult);
        }
    }

    public GameResult getGameResult() {
        return new GameResult(numberOfPhase, phaseResults);
    }
}
