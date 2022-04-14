package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_MAX = 9;
    private static List<Car> racingCars;
    private static int CAR_COUNT;
    private static int TRY_COUNT;

    public RacingCar(int carCount, int tryCount) {
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
        for (int i = 0; i < TRY_COUNT; i++) {
            for(Car car : racingCars) {
                move(car);
            }
            ResultView.printResult(racingCars);
        }
    }

    public void move(Car car) {
        int randomNumber = getRandomNumber();
        if(moveCondition(randomNumber)) {
            car.go();
        }
        car.stop();
    }

    public int getRandomNumber() {
        return new Random().nextInt(RANDOM_MAX);
    }


    public boolean moveCondition(int randomNumber) {
        if(isGoRange(randomNumber))   return true;
        return false;
    }

    public boolean isGoRange(int randomNumber) {
        return randomNumber >= 4 && randomNumber <= 9;
    }
}
