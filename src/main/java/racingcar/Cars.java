package racingcar;

import java.util.List;

public class Cars {
    private static final Generator generator = new RandomValueGenerator();
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void nextTrial() {
        for (Car car : carList) {
            car.nextTurn(generator);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
