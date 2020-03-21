package racingcar.domain;

import racingcar.RandomNumGenerator;
import racingcar.dto.InputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(InputView inputView) {
        cars = createCars(inputView);
    }

    private List<Car> createCars(InputView inputView) {
        List<String> carNames = inputView.getCarNames();
        return carNames.stream()
                .map(it -> new Car(it))
                .collect(Collectors.toList());
    }

    public void moveOnce(RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNumber = rng.generateNumberLessThan(10);
            boolean canRun = car.canRun(randomNumber);
            car.move(canRun);
        }
    }

    public List<Car> findWinner() {
        int highestPositionValue = findHighestPositionValue(cars);
        return cars.stream()
                .filter(it -> it.getPosition() == highestPositionValue)
                .collect(Collectors.toList());
    }


    private int findHighestPositionValue(List<Car> cars) {
        return cars.stream()
                .map(it -> it.getPosition())
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}