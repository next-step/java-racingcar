package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.List;

public class RacingCarGameService {
    private final Cars cars;

    public RacingCarGameService(RacingGameRequest request) {
        cars = new Cars(request.getCarNumber());
    }

    public RacingGameResponse start() {
        cars.moveAllCar();
        List<Integer> allMoveCount = cars.getAllMoveCount();
        return new RacingGameResponse(allMoveCount);
    }
}
