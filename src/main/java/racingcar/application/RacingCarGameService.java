package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameService {

    private final Cars cars;

    public RacingCarGameService() {
        cars = new Cars();
    }

    public void initializeCars(int carNumber) {
        while (carNumber > 0) {
            cars.addCar(new Car());
            carNumber = carNumber - 1;
        }
    }

    public List getAllCarMoveCount() {
        List<Integer> moveCounts = new ArrayList<>();
        for (Car car : cars.getAllCar()) {
            moveCounts.add(car.stopOrMove(getRandomValue()));
        }
        return moveCounts;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public int numberOfCar() {
        return cars.getNumberOfCar();
    }
}
