package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private final static String DELIMITER = ",";

    public Cars(String carName){
        this.cars = makeCars(carName);
    }

    public List<Car> makeCars(String carName) {
        List<String> carNames = splitCarNames(carName);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = Car.newCar(name);
            cars.add(car);
        }
        return cars;
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER));
    }

    public List<Car> getCars() {
        return cars;
    }
}
