package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.input.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class InputCar {

    private CarInfo carInfo;

    public InputCar(String value) {
        this.carInfo = new CarInfo(value);
    }

    public List<Car> toCars() {
        return carInfo.getCarNames()
                .stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
