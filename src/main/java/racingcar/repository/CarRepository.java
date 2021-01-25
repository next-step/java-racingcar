package racingcar.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {

    private final List<Car> carList = new ArrayList<>();

    public CarRepository() {
    }

    public List<Car> createCars(String[] cars) {
        Arrays.stream(cars).forEach(car -> carList.add(new Car(car)));
        return carList;
    }

    public List<Car> getCarList(){
        return carList;
    }
}
