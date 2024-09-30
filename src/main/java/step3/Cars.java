package step3;

import java.util.List;

public class Cars {
    List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public void moveAll(CarEngine carEngine) {
        for (Car car : carList) {
            car.move(carEngine);
        }
    }
}
