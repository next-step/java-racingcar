package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarConverter {

    public static List<Car> convertToCarList(List<String> carNames) {
        return carNames.stream().map(Car::from).collect(Collectors.toList());
    }

}
