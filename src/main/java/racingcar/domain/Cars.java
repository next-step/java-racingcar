package racingcar.domain;

import racingcar.RandomNumGenerator;
import racingcar.dto.InputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> findWinner() {
        int highestPositionValue = findHighestPositionValue(cars);
        return cars.stream()
                .filter(it -> it.getPosition() == highestPositionValue)
                .collect(Collectors.toList());
    }


    private int findHighestPositionValue(List<Car> cars) {
        return cars.stream()
                .map(it -> it.getPosition())
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(RuntimeException::new);
    }

    public List<Car> getCars() {
        return cars;
    }
}