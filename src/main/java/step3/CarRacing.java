package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> carList;

    public CarRacing(String[] carsName) {
        makeRacingCars(carsName);
    }

    private void makeRacingCars(String[] carsName) {
        carList = new ArrayList<>();
        for (String carName : carsName) {
            carList.add(new Car(carName));
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
