package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int tryCount;

    public RacingGame(int carCount, int tryCount) {
        this.tryCount = tryCount;
        for (int i = 0; i < carCount; i++) {
            this.carList.add(new Car(i + 1));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public boolean remainTryCount() {
        return this.tryCount >0;
    }

    public void racing() {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        carList.forEach(car->car.move(numberGenerator));
        reduceTryCount();
    }

    public void reduceTryCount() {
        tryCount--;
    }
}
