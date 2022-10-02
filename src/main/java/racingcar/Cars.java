package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final Generator generator = new RandomValueGenerator();
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars nextTrial() {
        List<Car> nextCars = new ArrayList<>();
        for (Car car : carList) {
            nextCars.add(car.nextTurn(generator));
        }
        return new Cars(nextCars);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
