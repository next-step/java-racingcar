package racingcar.application;

import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.HashMap;
import java.util.List;

public class RacingCarGameService {
    private Cars cars;

    public RacingGameResponse start(RacingGameRequest request) {
        HashMap<Integer, List<Integer>> moveCountsByTurn = new HashMap<>();
        cars = new Cars(request.getCarNumber());
        for (int currentTurn = 1; currentTurn <= request.getEndTurn(); currentTurn++) {
            moveCountsByTurn.put(currentTurn, getMoveCountsAfterAllMove());
        }
        return new RacingGameResponse(moveCountsByTurn);
    }

    private List<Integer> getMoveCountsAfterAllMove() {
        cars.moveAllCar();
        return cars.getAllMoveCount();
    }
}
