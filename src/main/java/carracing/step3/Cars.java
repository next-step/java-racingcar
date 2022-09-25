package carracing.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_BOUND = 10;
    private final List<Car> cars;

    public Cars(int carCount) {
        cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveAllCarsRandomly() {
        for (int i = 0; i < cars.size(); i++) {
            moveCarRandomly(i);
        }
    }

    private void moveCarRandomly(int carNum) {
        if (isMovable()) {
            cars.get(carNum).move();
        }
    }

    private boolean isMovable() {
        return new Random().nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public String getAllCarsTrace() {
        StringBuilder allCarTrace = new StringBuilder();
        for (Car car : cars) {
            allCarTrace.append(car.moveTrace()).append("\n");
        }
        return allCarTrace.toString();
    }

}
