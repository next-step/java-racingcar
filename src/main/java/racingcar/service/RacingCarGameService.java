package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameService {

    private List<Car> racingCars;
    private int CAR_COUNT;
    private int TRY_COUNT;

    public RacingCarGameService(int carCount, int tryCount) {
        CAR_COUNT = carCount;
        TRY_COUNT = tryCount;
        participateCars();
    }

    public void participateCars() {
        racingCars = new ArrayList<>();
        for (int i = 0; i < CAR_COUNT; i++) {
            racingCars.add(new Car());
        }
    }

    public void startGame() {
        System.out.println("실행결과");
        for (int i = 0; i < TRY_COUNT; i++) {
            for(Car car : racingCars) {
                CarService.move(car);
            }
            ResultView.printResult(racingCars);
        }
    }


}
