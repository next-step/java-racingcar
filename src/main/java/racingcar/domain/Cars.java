package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carName){
        this.cars = makeCars(carName);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = Car.newCar(name);
            cars.add(car);
        }
        return cars;
    }
}
