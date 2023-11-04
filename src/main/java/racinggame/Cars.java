package racinggame;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startRacing(int racingCount) {
        OutputView outputView = new OutputView();
        for (int i = 0; i < racingCount; i++) {
            racingCar();
            outputView.printRacing(cars);
        }
    }

    private void racingCar() {
        for (Car car : cars) {
            car.moving();
        }
    }

    public List<Car> getCar() {
        return Collections.unmodifiableList(cars);
    }

}
