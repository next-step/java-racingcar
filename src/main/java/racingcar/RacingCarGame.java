package racingcar;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static final int MAX_RANDOM_COUNT = 10;
    public static final int MOVABLE_MIN = 4;

    private int carCount;
    private int attemptCount;
    private int raceCount;

    private List<Car> carList;
    private ResultView resultView;

    public RacingCarGame(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
        this.raceCount = attemptCount - 1;

        this.carList = new ArrayList<>();
        this.resultView = new ResultView(this);
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
        firstRace(); // 첫번째 레이스는 출력만
        remainingRace(); // 나머지 레이스 부터 이동 및 출력
    }

    private void firstRace() {
        resultView.printRace();
        --raceCount;
    }

    private void remainingRace() {
        for (int i = 0; i < raceCount; i++) {
            moveCarList();
            resultView.printRace();
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
