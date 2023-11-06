package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static final int MAX_RANDOM_COUNT = 10;
    public static final int MOVABLE_MIN = 4;

    private int carCount;
    private int attemptCount;

    private List<Car> carList = new ArrayList<>();

    public RacingCarGame(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
    }

    public void start() {
        // 자동차 생성능
        createCar();
        // 자동차 이동
        race();
    }

    public void createCar() {
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    public void race() {
        for (int i = 0; i < attemptCount; i++) {
            moveCarList();
        }
    }

    private void moveCarList() {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    public void moveCar(Car car) {
        int value = random(MAX_RANDOM_COUNT);
        if(movable(value)){
            car.move();
        }
    }

    public boolean movable(int value) {
        return value >= MOVABLE_MIN;
    }

    public int random(int maxCount) {
        Random random = new Random();
        return random.nextInt(maxCount);
    }


    public int carCount() {
        return carCount;
    }

    public int attemptCount() {
        return attemptCount;
    }

    public List<Car> carList() {
        return carList;
    }
}
