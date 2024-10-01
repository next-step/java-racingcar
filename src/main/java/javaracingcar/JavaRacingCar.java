package javaracingcar;

import javaracingcar.entity.RacingCar;
import javaracingcar.view.InputView;
import javaracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaRacingCar {

    private static final int RANDOM_VALUE_RANGE = 10;
    private static final Random random = new Random();
    private static final List<RacingCar> cars = new ArrayList<>();

    private static int step = 0;
    private static int tryCount = 0;

    public JavaRacingCar() {
    }

    public void execution() {
        requireCarCount(InputView.requireCarCount());
        requireTryCount(InputView.requireTryCount());
        start();
    }

    private void validateNegativeNumber(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    public void requireCarCount(int carCount) throws RuntimeException {
        validateNegativeNumber(carCount);
        this.step = 1;
        initCars(carCount);
    }

    private void initCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar());
        }
    }

    public void requireTryCount(int tryCount) throws RuntimeException {
        validateNegativeNumber(tryCount);
        this.step = 2;
        this.tryCount = tryCount;
    }

    public List<RacingCar> start() {
        ResultView.resultStartMessage();
        for (int i = 0; i < tryCount; i++) {
            startRound();
        }
        return this.cars;
    }

    private void startRound() {
        for (RacingCar racingCar : this.cars) {
            decideCarLocation(racingCar);
        }
        ResultView.endRound(this.cars);
    }

    private void decideCarLocation(RacingCar racingCar) {
        if (racingCar.isMove(random())) {
            racingCar.go();
        }
    }

    public int random() {
        return random.nextInt(RANDOM_VALUE_RANGE);
    }

    public int step() {
        return this.step;
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

}
