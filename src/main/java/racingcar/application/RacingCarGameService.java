package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Strategy;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingCarGameService {
    private int endTurn;
    private Cars cars;
    private List<String> winners = new ArrayList<>();

    public RacingGameResponse start(RacingGameRequest request) {
        endTurn = request.getEndTurn();
        cars = new Cars(request.getCarNames());
        HashMap<Integer, List<Car>> movedCarsByTurn = getMovedCarsByTurn();
        return new RacingGameResponse(movedCarsByTurn, findWinners(movedCarsByTurn));
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

    private List<String> findWinners(HashMap<Integer, List<Car>> movedCarsByTurn) {
        List<Car> carsInEndTurn = movedCarsByTurn.get(endTurn);
        for (Car car : carsInEndTurn) {
            decisionWinner(car, endTurn);
        }
        return winners;
    }

    private void decisionWinner(Car car, int endTurn) {
        if (car.getMoveCount() == endTurn) {
            winners.add(car.getName());
        }
    }
}
