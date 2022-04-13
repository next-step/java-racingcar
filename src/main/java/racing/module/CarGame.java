package racing.module;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final List<Car> carList = new ArrayList<>();

    public CarGame(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            carList.add(new Car());
        }
    }

    public void play(NumberGenerator generator, int number) {
        for (Car car : carList) {
            car.move(generator.getNumber(number));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
