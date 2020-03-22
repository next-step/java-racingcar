package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> carList = new ArrayList<Car>();

    public void createCars(int carCount) {
        List<Car> carList = new ArrayList<Car>();

        for(int i = 0; i < carCount; i++) {
            carList.add(_createCar());
        }
        this.carList = carList;
    }

    private Car _createCar() {
        Car car = new Car();

        return car;
    }
}


