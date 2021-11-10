package racingcar;

import common.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final ListView<Car> carListView;
    private final int tryCount;
    private final Random random;

    public Racing(int carCount, int tryCount) {
        this.carListView = new ListView<>(makeCar(carCount));
        this.tryCount = tryCount;
        this.random = new Random(System.currentTimeMillis());
    }

    public List<Car> makeCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void goingTry() {
        for (Car car : carListView.getList()) {
            car.increaseState(random.nextInt(10));
        }
    }

    public List<Car> getCarList() {
        return carListView.getList();
    }
}
