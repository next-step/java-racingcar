package racingCar.model;

import racingCar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;
    private int playCount;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public void move() {
        for (Car car : carList) {
            car.move(RandomUtil.getNumber());
        }
    }
}
