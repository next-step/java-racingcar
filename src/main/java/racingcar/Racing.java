package racingcar;

import java.util.*;
import java.util.Random;

public class Racing {

    private final int carsNum;
    private final int gameCount;
    private List<Car> cars;

    public Racing(int carsNum, int gameCount) {
        this.carsNum = carsNum;
        this.gameCount = gameCount;
        this.cars = createCars(carsNum);
    }

    private List<Car> createCars(int carsNum) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < carsNum; i++) {
            result.add(new Car());
        }
        return result;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void race() {
        for (int i = 0; i < gameCount; i++) {
            game();
        }
    }

    private void game() {
        for (Car car : cars) {
            car.move(random());
        }
    }

    private int random() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
