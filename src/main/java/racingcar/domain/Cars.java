package racingcar.domain;

import racingcar.constant.RacingMessage;
import racingcar.util.Splitter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars(String carNames) {
        this.carList = Collections.unmodifiableList(readyCars(carNames));
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    private List<Car> readyCars(String carNames) {
        List<String> names = Splitter.splitText(carNames);
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        return carList.stream()
                .filter(car -> car.isFirstPosition(findFirstPositionCar()))
                .collect(Collectors.toList());
    }

    public Car findFirstPositionCar() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new NoSuchElementException(RacingMessage.NOT_FOUND_FIRST_POSITION_CAR));
    }

    public void moveCars() {
        for (Car car : this.carList) {
            car.move();
        }
    }
}
