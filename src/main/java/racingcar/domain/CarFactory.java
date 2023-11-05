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

    public void participants(String CarNames) {
        List<String> carNames = ValidityCheck.carNameCheck(CarNames);
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
