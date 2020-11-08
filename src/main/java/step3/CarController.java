package step3;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarController {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    public void start(int numberOfCars, int tryCounts) {
        CarList carList = initCarList(numberOfCars);

        OutputView.resultMention();

        for(int tryNumber = 0; tryNumber < tryCounts; tryNumber++) {
            nextPosition(carList);
        }
    }

    private CarList initCarList(int numberOfCars) {
        List<Car> carList = IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        return CarList.from(carList);
    }

    private void nextPosition(CarList carList) {
        List<Car> cars = carList.getCarList();
        for(Car car : cars) {
            car.move(makeRandomValue());
        }
        OutputView.displayCarList(cars);
    }

    private int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }
}
