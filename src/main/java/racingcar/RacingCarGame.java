package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
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
