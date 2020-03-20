package racingcar.domain;

import racingcar.RandomNumGenerator;
import racingcar.dto.InputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(InputView inputView) {
        createCars(inputView);
    }

    private void createCars(InputView inputView) {
        int carCount = inputView.getCarCount();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveOnce(RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNumber = rng.generateNumberLessThanTen();
            boolean canRun = car.canRun(randomNumber);
            car.move(canRun);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}