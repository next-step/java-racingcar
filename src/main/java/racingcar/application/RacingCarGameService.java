package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.HashMap;
import java.util.List;

public class RacingCarGameService {
    private int endTurn;
    private Cars cars;

    public RacingGameResponse start(RacingGameRequest request) {
        endTurn = request.getEndTurn();
        cars = new Cars(request.getCarNames());
        HashMap<Integer, List<Car>> movedCarsByTurn = getMovedCarsByTurn();
        return new RacingGameResponse(movedCarsByTurn, cars.findWinners(endTurn));
    }

    private HashMap<Integer, List<Car>> getMovedCarsByTurn() {
        HashMap<Integer, List<Car>> movedCarsByTurn = new HashMap<>();
        for (int currentTurn = 1; currentTurn <= endTurn; currentTurn++) {
            movedCarsByTurn.put(currentTurn, getMovedCars());
        }
        return movedCarsByTurn;
    }

    private List<Car> getMovedCars() {
        cars.moveAllCar();
        return cars.getAllCar();
    }
}
