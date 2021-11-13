package racing.model;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> nameList) {
        this.carList = makeCarList(nameList);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public List<Car> makeCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<Car>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }
    public void playRacing(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.movable(moveStrategy);
        }
    }
}
