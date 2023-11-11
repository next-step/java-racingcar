package racingcar.factory;

import racingcar.domain.Car;
import racingcar.domain.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> generate(List<String> carsName) {
        return carsName.stream().map(name -> new Car(name)).collect(Collectors.toList());
    }
}
