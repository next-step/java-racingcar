package racingcar.step3_4.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.NoSuchElementException;
import racingcar.step3_4.strategy.ValueGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(Names carNames) {
        return carNames.getNames()
            .stream()
            .map(Car::new)
            .collect(collectingAndThen(toList(), Cars::new));
    }

    public void move(ValueGenerator valueGenerator) {
        for (Car car : cars) {
            car.move(valueGenerator);
        }
    }

    public Winners determineWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == getMaxPosition())
            .collect(collectingAndThen(toList(), Winners::new));
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new NoSuchElementException("우승 위치의 자동차가 존재하지 않습니다."));
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return List.copyOf(this.cars);
    }
}
