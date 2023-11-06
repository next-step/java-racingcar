package racingcar.domain;

import racingcar.validite.ValidityCheck;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> participants(List<String> carNames) {
        ValidityCheck.carNameCheck(carNames);
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
