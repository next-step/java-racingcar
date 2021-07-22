package racingcar.vehicle;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.RandomUtil;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(CarFactory.create(car.getDistance()));
    }

    public void doDrive() {
        cars.forEach(car -> car.drive(RandomUtil.nextInt(10)));
    }

    public int size() {
        return cars.size();
    }

    public int getDistance(int index) {
        return cars.get(index).getDistance();
    }
}

