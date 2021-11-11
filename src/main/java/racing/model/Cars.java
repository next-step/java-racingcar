package racing.model;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public Cars(List<String> nameList) {
        List<Car> carList = new ArrayList<Car>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        this.carList =  carList;
    }

    public void movableCarList(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.movable(moveStrategy);
        }
    }
}
