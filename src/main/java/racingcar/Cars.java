package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public List<Car> carList() {
        return this.carList;
    }

    public void add() {
        carList.add(new Car());
    }

    public void add(int number) {
        for (int i = 0; i < number; i++) {
            carList.add(new Car());
        }
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }
}
