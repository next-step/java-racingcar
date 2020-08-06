package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> raceCars(List<Car> cars, int racingCounts) {
        List<Car> carList = new ArrayList<Car>();
        for (i = 1; i <= racingCounts; i++) {
            for (j = 0; j < cars.size(); j++) {
                return carList.add(cars[j].move());
            }
        }
    }

}