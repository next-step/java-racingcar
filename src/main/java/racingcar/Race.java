package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public Race(int carCnt) {
        ready(carCnt);
    }

    private void ready(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car(0));
        }
    }

    public List<Car> playRace() {
        for (Car car : cars) {
            car.move(RandomNum.makeRandomNum());
        }
        return cars;
    }
}
