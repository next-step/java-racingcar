package controller;

import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private TryNumber tryNumber;

    public RacingGame(String carNames, int tryNumber) {
        this(new Cars(carNames), new TryNumber(tryNumber));
    }

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public boolean isEnd() {
        return tryNumber.isEnd();
    }

    public List<String> race() {
        tryNumber.increase();
        cars.move();

        return cars.status();
    }

    public List<String> winners() {
        return cars.getWinners();
    }
}
