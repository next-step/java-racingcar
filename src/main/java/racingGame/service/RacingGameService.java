package racingGame.service;

import racingGame.model.car.Car;
import racingGame.model.numbergenerator.NumberGenerator;
import racingGame.model.numbergenerator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private static final String CAR_COUNT_ERROR_MESSAGE = "최소 2대 이상은 입력해주세요!";

    private static final int MINIMUM_CAR_COUNT = 2;

    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public RacingGameService(int carCount) {
        validateCarCount(carCount);
        cars = createCars(carCount);
        this.numberGenerator = new RandomNumberGenerator();
    }

    public List<Car> moveAllCars() {
        for (Car car : cars) {
            int number = numberGenerator.generateNumber();
            car.move(number);
        }
        return cars;
    }

    private List<Car> createCars(int carCount) {
        List<Car> ret = new ArrayList<>();
        for (int i = 0 ; i < carCount; i++) {
            ret.add(new Car());
        }
        return ret;
    }

    private void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

}
