package racing.module;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final List<Car> carList = new ArrayList<>();

    public CarGame(String  carName) {
        String[] names = carName.split(",");

        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public void play(MoveStrategy strategy) {
        for (Car car : carList) {
            car.attempt(strategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
