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
        for (int i = 0; i < inputView.getCarCount(); i++) {
            List<String> carNames = inputView.getCarNames();
            cars.add(new Car(carNames.get(i)));
        }
    }

    public void moveOnce(RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNumber = rng.generateNumberLessThan(10);
            boolean canRun = car.canRun(randomNumber);
            car.move(canRun);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}