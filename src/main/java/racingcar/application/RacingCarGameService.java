package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.HashMap;
import java.util.List;

public class RacingCarGameService {

    public RacingGameResponse start(RacingGameRequest request) {
        int endTurn = request.getEndTurn();
        Cars cars = new Cars(request.getCarNames());
        HashMap<Integer, List<Car>> movedCarsByTurn = getMovedCarsByTurn(cars, endTurn);
        return new RacingGameResponse(movedCarsByTurn, cars.findWinners(endTurn));
    }

    private HashMap<Integer, List<Car>> getMovedCarsByTurn(Cars cars, int endTurn) {
        HashMap<Integer, List<Car>> movedCarsByTurn = new HashMap<>();
        for (int currentTurn = 1; currentTurn <= endTurn; currentTurn++) {
            movedCarsByTurn.put(currentTurn, getMovedCars(cars));
        }
        return movedCarsByTurn;
    }

    private List<Car> getMovedCars(Cars cars) {
        cars.moveAllCar();
        return cars.getAllCar();
    }
}
