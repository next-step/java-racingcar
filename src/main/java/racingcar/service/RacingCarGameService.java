package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private List<Car> racingCars;
    private int carCount;
    private int tryCount;

    public RacingCarGameService(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        participateCars();
    }

    public void participateCars() {
        racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new Car());
        }
    }

    public void startGame() {
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            moveRacingCars();
            ResultView.printResult(racingCars);
        }
    }

    private void moveRacingCars() {
        for(Car car : racingCars) {
            car.move(new RandomMoveStrategy());
        }
    }


}
