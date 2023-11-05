package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameService {

    private final Cars cars;

    public RacingCarGameService() {
        cars = new Cars();
    }

    public void initializeCars(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            cars.addCar(new Car());
        }
    }

    public RacingGameResponse getAllCarMoveCount() {
        moveAllCar();
        List<Integer> moveCounts = new ArrayList<>();
        for (Car car : cars.getAllCar()) {
            moveCounts.add(car.getMoveCount());
        }
        return new RacingGameResponse(moveCounts);
    }

    private void moveAllCar() {
        for (Car car : cars.getAllCar()) {
            car.stopOrMove(getRandomValue());
        }
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public int numberOfCar() {
        return cars.getNumberOfCar();
    }
}
