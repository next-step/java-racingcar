package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<String> movingList;

    public Car() {
        this.movingList = new ArrayList<>();
    }

    public List<String> getMovingList() {
        return movingList;
    }

    public static List<Car> factory(int numOfCars) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < numOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
