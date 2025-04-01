package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public boolean isCarCount(int carCount) {
        return this.cars.size() == carCount;
    }

    public void print(int moveCount) {
        for (int round = 1; round <= moveCount; round++) {
            for (Car car : cars) {
                car.print(round);
            }
            OutputView.drawLineSeparator();
        }
    }
}
