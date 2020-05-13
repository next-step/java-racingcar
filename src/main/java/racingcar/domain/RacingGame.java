package racingcar.domain;

import racingcar.domain.car.NumberGenerator;
import racingcar.domain.car.ParticipateCars;
import racingcar.dto.InputValueDto;

import java.util.List;

public class RacingGame {
    private int numberOfPhase;
    private ParticipateCars participateCars;

    public RacingGame(InputValueDto inputValueDto) {
        this.numberOfPhase = inputValueDto.getNumberOfPhase();
        this.participateCars = new ParticipateCars(inputValueDto.getNumberOfCar());
    }

    public GameResult startGame(NumberGenerator numberGenerator) {
        GameResult gameResult = new GameResult(numberOfPhase);

        for (int i = 0; i < numberOfPhase; i++) {
            List<Integer> raceResult = participateCars.moveCars(numberGenerator);
            gameResult.addPhaseResult(new PhaseResult(raceResult));
        }

        return gameResult;
    }
}
