package step3.study;

import java.util.List;

public class Racing {
    private int carCount;
    private int tryCount;
    private List<Car> cars;

    public Racing(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        cars = RacingUtil.createCars(carCount);
    }

    public void start() {
        RacingManager racingManager = new RacingManager();

        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            racingManager.moveCars(cars);
            System.out.println("");
        }
    }
}
