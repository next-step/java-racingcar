package racing.module;

import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGame {
    private final Random RANDOM = new Random();
    private final List<Car> carList = new ArrayList<>();

    public CarGame(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            carList.add(new Car(0));
        }
    }

    public void play() {
        for (Car car : carList) {
            car.move(RANDOM.nextInt(10));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
