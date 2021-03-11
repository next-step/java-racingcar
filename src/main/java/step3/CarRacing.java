package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> carList;

    public CarRacing(int carsCount) {
        makeRacingCars(carsCount);
    }

    private void makeRacingCars(int carsCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            carList.add(new Car());
        }
    }

    public void moveForward() {
        for (Car car : carList) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
