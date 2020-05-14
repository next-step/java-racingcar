package racingcar.domain;

import racingcar.domain.car.NumberGenerator;
import racingcar.domain.car.ParticipateCars;
import racingcar.dto.InputValueDto;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int numberOfPhase;
    private ParticipateCars participateCars;
    private List<PhaseResult> phaseResults;

    public RacingGame(InputValueDto inputValueDto) {
        this.numberOfPhase = inputValueDto.getNumberOfPhase();
        this.participateCars = new ParticipateCars(inputValueDto.getNumberOfCar());
        this.phaseResults = new ArrayList<>();
    }

    public void startGame(NumberGenerator numberGenerator) {
        for (int phase = 0; phase < numberOfPhase; phase++) {
            List<Integer> carsLocationAfterMove = participateCars.moveCars(numberGenerator);
            PhaseResult phaseResult = new PhaseResult(carsLocationAfterMove);
            phaseResults.add(phaseResult);
        }
    }

    public GameResult getGameResult() {
        return new GameResult(numberOfPhase, phaseResults);
    }
}
