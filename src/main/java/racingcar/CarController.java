package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarController {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    public CarList initCarList(String[] carNames) {
        List<Car> carList = Arrays.stream(carNames)
                .map(Car::makeCar)
                .collect(Collectors.toList());

        return CarList.from(carList);
    }

    public CarList nextRound(CarList carList) {
        List<Car> cars = carList.getCarList();
        for(Car car : cars) {
            car.move(makeRandomValue());
        }
        return CarList.from(cars);
    }

    private int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }
}
