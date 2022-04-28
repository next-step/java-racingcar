package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames, CarActionStrategy carActionStrategy) {
        this(carNames.getCarNames()
                .stream()
                .map(name -> new Car(name, carActionStrategy))
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        if (isNullOrEmpty(cars)) {
            throw new IllegalArgumentException("빈 컬렉션은 Cars를 생성 할 수 없다.");
        }
    }

    private boolean isNullOrEmpty(List<Car> cars) {
        return cars == null || cars.isEmpty();
    }

    public Cars act() {
        return new Cars(cars.stream()
                .map(Car::act)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinnerCars() {
        int winnerPosition = getWinnerPosition();
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new NoSuchElementException("car없이 승자를 구할 수 없습니다."));
    }
}
