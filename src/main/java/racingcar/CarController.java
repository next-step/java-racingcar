package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public List<String> getWinner(CarList carList) {
        List<Car> finalCarList = carList.getCarList();
        List<String> winners = new ArrayList<>();

        int previousPosition = -1;
        for(Car car : finalCarList) {
            int currentPosition = car.getCurrentPosition();
            if(currentPosition > previousPosition) {
                previousPosition = currentPosition;
                winners = new ArrayList<>();
                winners.add(car.getName());
            } else if (currentPosition == previousPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
