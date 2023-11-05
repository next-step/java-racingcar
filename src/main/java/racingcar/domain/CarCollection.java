package racingcar.domain;

import racingcar.validite.ValidityCheck;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {

    private List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void participants(List<String> carNames) {
        ValidityCheck.carNameCheck(carNames);
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
