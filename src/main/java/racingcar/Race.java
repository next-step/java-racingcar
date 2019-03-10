package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public Race(int carCount) {
        this.carList = setupCar(carCount);
    }

    private List<Car> setupCar(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void run() {
        for (Car car : carList) {
            if (car.canMove()) {
                car.moveCar();
            }
        }
    }


}
