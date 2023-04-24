package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM_BOX = new Random();

    private final int moveCount;
    private final List<Car> cars;

    private int currentMoveCount = 0;


    public Racing(int carCount, int moveCount) {
        validation(carCount);
        validation(moveCount);

        this.moveCount = moveCount;

        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public static void validation(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(String.format("양의 정수만 입력 가능합니다. (`%d`)", count));
        }
    }

    private boolean canRun() {
        return currentMoveCount < moveCount;
    }

    private int getRandomNumber() {
        return RANDOM_BOX.nextInt(RANDOM_BOUND);
    }

    public void run() {
        if (canRun()) {
            cars.forEach(car -> car.move(getRandomNumber()));
            currentMoveCount++;
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
