package racingcar.model;

import racingcar.util.NumberGenerator;

import static racingcar.model.Car.DEFAULT_POSITION;
import static racingcar.model.NamesValidator.CAR_NAMES_DELIMITER;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String names) {
        String[] namesArray = names.split(CAR_NAMES_DELIMITER);
        if (namesArray.length < 2) {
            throw new IllegalArgumentException("자동차는 2대이상이어야 합니다.");
        }
        List<Car> cars = Arrays.stream(namesArray)
                .map(Car::create)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
