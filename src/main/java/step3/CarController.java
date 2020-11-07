package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarController {

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
            car.move(car.makeRandomValue());
        }
        OutputView.displayCarList(cars);
    }
}
