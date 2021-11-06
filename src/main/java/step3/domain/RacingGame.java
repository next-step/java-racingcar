package step3.domain;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int rap;
    private List<Car> cars = new ArrayList<>();

    private RacingGame(int rap, List<Car> cars) {
        this.rap = rap;
        this.cars = cars;
    }

    public static RacingGame create(int rap, List<Car> cars) {
        return new RacingGame(rap, cars);
    }

    public void start() {
        validate();
        ResultView.start();
        for (int round = 0; round < rap; round++) {
            moveCar();
            ResultView.result(cars);
        }
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void validate() {
        validateRap();
        validateCars();
    }

    private void validateRap() {
        if (rap <= 0) {
            throw new IllegalArgumentException("시도 회수는 0보다 큰 값을 입력해 주세요");
        }
    }

    private void validateCars() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
