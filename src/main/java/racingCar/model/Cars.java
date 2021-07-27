package racingCar.model;

import racingCar.utils.RandomUtil;
import racingCar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private int playCount;

    public Cars(int carCount, int playCount) {
        this.cars = makeCars(carCount);
        this.playCount = playCount;
    }

    private List<Car> makeCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(RandomUtil.getNumber());
            ResultView.printLocation(car.getLocation());
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
