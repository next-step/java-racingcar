package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Car> cars;

    public Result(List<Car> carList) {
        cars = new ArrayList<>();
        for (Car car : carList) {
            cars.add(car);
        }
    }

    public List<Integer> getCarLocation() {
        List<Integer> carLocationList = new ArrayList<>();
        for (Car car : cars) {
            carLocationList.add(car.getLocation());
        }

        return carLocationList;
    }
}
