package racing.domain;

import racing.strategy.MovingStrategy;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : carList) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
