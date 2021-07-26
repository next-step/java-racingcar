package racingCar.model;

import racingCar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;
    private int playCount;

    public Cars(int carCount, int playCount) {
        this.carList = addCars(carCount);
        this.playCount = playCount;
    }

    private List<Car> addCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : carList) {
            car.move(RandomUtil.getNumber());
            car.printLocation();
            System.out.println();
        }
    }

    public void play() {
        for (int i = 0; i < playCount; i++) {
            moveCars();
            System.out.println();
        }
    }
}
