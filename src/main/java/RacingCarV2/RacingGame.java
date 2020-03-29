package RacingCarV2;

import RacingCarV2.model.Car;
import RacingCarV2.model.StageResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int LIMIT = 10;
    private static final int THRESHOLD = 4;


    List<StageResult> start(List<String> names, int stage) {
        List<Car> cars = initCars(names);
        List<StageResult> stageResults = new ArrayList<>();

        for (int i = 0; i < stage; i++) {
            move(cars);
            stageResults.add(new StageResult(cars));
        }

        return stageResults;
    }


    void move(List<Car> cars) {
        for (Car car : cars) {
            int count = getMoveCount();
            car.moveCar(count);
        }
    }


    boolean isMovable(int moveCount) {
        return moveCount >= THRESHOLD;
    }

    private int getMoveCount() {
        int move = getRandom();
        return isMovable(move) ? ONE : ZERO;
    }

    private int getRandom() {
        return new Random().nextInt(LIMIT);
    }

    List<Car> initCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
