package carracing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주를 같이하는 자동차들을 표현한 클래스
 */
public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        validateCars(carNames);
        List<CarName> names = carNames.getNames();
        this.cars = new ArrayList<>(names.size());
        for (CarName name : names) {
            cars.add(new Car(name));
        }
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveCars(MovementPolicy movementPolicy) {
        return new Cars(movedCars(movementPolicy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> retrieveWinningCars() {
        return cars.stream()
                .filter(car -> car.isWon(winningPositionNumber()))
                .collect(Collectors.toList());
    }

    private void validateCars(CarNames carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException("자동차들을 초기화 하기 위해서는 자동차 이름들이 필요합니다.");
        }
    }

    private List<Car> movedCars(MovementPolicy movementPolicy) {
        return cars.stream()
                .map(car -> car.move(movementPolicy))
                .collect(Collectors.toList());
    }

    private int winningPositionNumber() {
        return cars.stream()
                .map(Car::getPosition)
                .map(CarPosition::getNumber)
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("우승한 자동차가 없습니다."));
    }
}
