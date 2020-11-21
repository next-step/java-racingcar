package racingcar.domain;

import racingcar.dto.input.CarNames;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;
import static racingcar.common.Constant.SPLIT_LETTER;

public class CarFactory {

    public Cars createCars(CarNames carNames) {
        List<Car> cars = carNames.split(SPLIT_LETTER).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }


}
