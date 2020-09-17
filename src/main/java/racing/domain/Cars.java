package racing.domain;

import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> carList;

    public Cars(int carNumber) {
        carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
    }

    public void runCars() {
        for (Car car : carList) {
            car.run(car.getRandomNumber());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
