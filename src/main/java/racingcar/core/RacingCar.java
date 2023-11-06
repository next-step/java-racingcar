package racingcar.core;

import racingcar.ui.RacingResultView;

import java.util.List;

public class RacingCar {
    private static final int DEFAULT_FORWARD_CNT = 0;
    private static final int CONDITION_NUMBER = 4;
    private int raceTimes;
    private List<Car> cars;

    public RacingCar(int raceTimes, List<Car> cars) {
        this.raceTimes = raceTimes;
        this.cars = cars;
    }

    public void start() {
        RacingResultView racingResultView = new RacingResultView();
        System.out.println("실행 결과");
        for (int i = 0; i < raceTimes; i++) {
            goRace(raceTimes, cars);
            racingResultView.resultView(cars);
        }
    }

    private void goRace(int raceTimes, List<Car> cars) {
        moveCar(cars);
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
    }
}
