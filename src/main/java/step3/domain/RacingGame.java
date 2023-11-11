package step3.domain;

import step3.dto.InputDTO;
import step3.dto.OutputDTO;

public class RacingGame {
    public OutputDTO service(InputDTO inputDTO) {

        Cars cars = new Cars(inputDTO.getCarNames(), 0);
        MoveCars moveCars = new MoveCars(inputDTO.getTurnCount(), inputDTO.getDecisionValue(), cars);
        moveCars.race();

        return new OutputDTO(moveCars.getRacingLog(), new RaceWinner().getWinners(cars));

    }
}
