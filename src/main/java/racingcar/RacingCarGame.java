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
        // 자동차 생성
        // 자동차 이동
        // 결과 화면 출력
    }

    public void createCar() {
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    public void race() {
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

    private int random(int maxCount) {
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
