package racingcar.ui.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.HashMap;
import java.util.List;

public class RacingGameResponse {
    private HashMap<Integer, List<Car>> movedCarsByTurn;
    private Cars cars;

    public RacingGameResponse(HashMap<Integer, List<Car>> movedCarsByTurn, Cars cars) {
        this.movedCarsByTurn = movedCarsByTurn;
        this.cars = cars;
    }

    public HashMap<Integer, List<Car>> getMovedCarsByTurn() {
        return movedCarsByTurn;
    }

    public Cars getCars() {
        return cars;
    }
}
