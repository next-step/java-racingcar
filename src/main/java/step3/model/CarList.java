package step3.model;

import step3.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public CarList(Integer countOfCar) {
        List<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < countOfCar; i++) {
            carList.add(new Car());
        }
        this.carList =  carList;
    }

    public void movableCarList(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.movable(moveStrategy);
        }
    }
}
