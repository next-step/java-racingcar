package racingcar;

import common.ListView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final ListView<Car> carListView;
    private final int tryCount;

    public Racing(int carCount, int tryCount) {
        this.carListView = new ListView<>(makeCar(carCount));
        this.tryCount = tryCount;
    }

    public List<Car> makeCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void goingTry() {
        for (Car car : carListView.getViewList()) {
            car.increaseState(10);
        }
    }


    public List<Car> getCarList() {
        return carListView.getViewList();
    }
}
