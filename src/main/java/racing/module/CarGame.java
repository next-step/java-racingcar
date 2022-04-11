package racing.module;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private static final List<Car> CarList = new ArrayList<>();

    public CarGame(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            CarList.add(new Car(0));
        }
    }

    public void playAndPrint() {
        for (Car car : CarList) {
            car.move();
            car.printPosition();
        }
        System.out.print("\n");
    }
}
