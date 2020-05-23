package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private final int moveCount;
    List<Cars> carsList = new ArrayList<>();

    public RacingCarGame(String carNames, int moveCount) {
        this.cars = Cars.createCars(carNames);
        this.moveCount = moveCount;
    }

    public Cars getCars() {
        return cars;
    }

    public void execute(Strategy strategy) {
        for (int i = 0; i < moveCount; i++) {
            cars.carRacing(strategy);
            carsList.add(cars);
        }
    }

    public Cars getWinners() {
        return cars.getWinners();
    }

    public List<Cars> getCarsList() {
        return carsList;
    }
}

