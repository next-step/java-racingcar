package racingcar.domain;

import racingcar.validite.ValidityCheck;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private List<Car> cars;

    public CarFactory() {
        this.cars = new ArrayList<>();
    }

    public List<Car> carsInfo() {
        return cars;
    }

    public void participants(String carNames) {
        List<String> carNameList = ValidityCheck.carNameCheck(carNames);
        for (String name : carNameList) {
            cars.add(new Car(name));
        }
    }
}
