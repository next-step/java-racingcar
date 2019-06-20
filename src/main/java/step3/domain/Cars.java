package step3.domain;

import step3.utils.NumberGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(CarNames carNames) {
        return new Cars(carNames.getCarNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public int findWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
    }

    public Cars move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getRandomNumber());
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
