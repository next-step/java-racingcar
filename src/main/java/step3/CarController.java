package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarController {
    private static final Random random = new Random();
    private static final int MAX_MOVING_BOUNDARY = 10;

    public List<CarList> gameStart(int numberOfCars, int tryCounts) {
        CarList carList = initCarList(numberOfCars);
        List<CarList> carListResult = new ArrayList<>();

        for(int tryNumber = 0; tryNumber < tryCounts; tryNumber++) {
            carListResult.add(nextPosition(carList));
        }

        return carListResult;
    }

    public CarList initCarList(int numberOfCars) {
        List<Car> carList = Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
        return CarList.from(carList);
    }

    public CarList nextPosition(CarList carList) {
        List<Car> cars = carList.getCarList();
        List<Car> newCarList = new ArrayList<>();
        for(Car car : cars) {
            car.move(makeRandomValue());
            newCarList.add(Car.makeNewCar(car.getCurrentPosition()));
        }
        return CarList.from(newCarList);
    }

    private int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }
}
