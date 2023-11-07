package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.List;

public class RacingCarGameService {
    private Cars cars;

    public RacingGameResponse start(RacingGameRequest request) {
        cars = new Cars(request.getCarNumber());
        RacingGameResponse response = new RacingGameResponse();
        for (int currentTurn = 1; currentTurn <= request.getEndTurn(); currentTurn++) {
            response.setMoveCountByTurn(currentTurn, getMoveCountsAfterAllMove());
        }
        return response;
    }

    private List<Integer> getMoveCountsAfterAllMove() {
        cars.moveAllCar();
        return cars.getAllMoveCount();
    }
}
