package javaracingcar;

import javaracingcar.entity.RacingCar;
import javaracingcar.view.InputView;
import javaracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaRacingCar {

    private static final int RANDOM_VALUE_RANGE = 10;
    private static final int MIN_MOVING_RANGE = 4;
    private static final int MAX_MOVING_RANGE = 9;

    private int step = 0;
    private int tryCount = 0;

    private Random random = new Random();
    private List<RacingCar> carList = new ArrayList<>();

    protected JavaRacingCar() {
    }

    public void execution() {
        this.requireGameInfo();
    }

    protected void requireGameInfo() {
        this.requireCarCount(InputView.requireCarCount());
        this.requireTryCount(InputView.requireTryCount());
        this.start();
    }

    private void validateNegativeNumber(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    protected void requireCarCount(int carCount) throws RuntimeException {
        validateNegativeNumber(carCount);
        this.step = 1;
        initCars(carCount);
    }

    private void initCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new RacingCar(i + 1));
        }
    }

    protected void requireTryCount(int tryCount) throws RuntimeException {
        validateNegativeNumber(tryCount);
        this.step = 2;
        this.tryCount = tryCount;
    }

    protected List<RacingCar> start() {
        ResultView.resultStartMessage();
        for (int i = 0; i < tryCount; i++) {
            startRound();
        }
        return this.carList;
    }

    private void startRound() {
        for (RacingCar racingCar : this.carList) {
            decideCarLocation(racingCar);
        }
        ResultView.endRound(this.carList);
    }

    private void decideCarLocation(RacingCar racingCar) {
        if (isMove(random())) {
            racingCar.go();
        }
    }

    protected int random() {
        return random.nextInt(RANDOM_VALUE_RANGE);
    }

    protected boolean isMove(int randomValue) {
        if (MIN_MOVING_RANGE <= randomValue && randomValue <= MAX_MOVING_RANGE) {
            return true;
        }
        return false;
    }

    protected int step() {
        return this.step;
    }

    protected List<RacingCar> carList() {
        return this.carList;
    }

}
