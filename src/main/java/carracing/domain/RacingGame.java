package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVABLE_NUMBER = 4;

    private static final List<Car> carList = new ArrayList<>();
    private static int tryCount;

    Random random = new Random();

    public RacingGame(int carCount, int pTryCount) {
        tryCount = pTryCount;

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(i + 1));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public boolean remainTryCount() {
        if (this.tryCount <= 0) {
            return false;
        }
        return true;
    }

    public void racing() {
        carList.forEach(a -> {
            if (canMove()) {
                a.move();
            }
        });
        reduceTryCount();
    }

    public boolean canMove() {
        return random.nextInt(RANDOM_RANGE) >= MOVABLE_NUMBER;
    }

    public void reduceTryCount() {
        tryCount--;
    }
}
