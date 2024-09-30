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

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private Random random = new Random();
    private List<RacingCar> carList = new ArrayList<>();

    protected int random() {
        int randomValue = random.nextInt(RANDOM_VALUE_RANGE);
        return randomValue;
    }

    protected boolean isMove(int randomValue) {

        if (MIN_MOVING_RANGE <= randomValue && randomValue <= MAX_MOVING_RANGE) {
            return true;
        }

        return false;
    }

    public void requireCarCount(int carCount) throws RuntimeException {

        if (carCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }

        this.step = 1;

        for (int i = 0; i < carCount; i++) {
            carList.add(new RacingCar(i + 1));
        }
    }

    public void requireTryCount(int tryCount) throws RuntimeException {

        if (tryCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }

        this.step = 2;
        this.tryCount = tryCount;
    }

    public int step() {
        return this.step;
    }

    public List<RacingCar> carList() {
        return this.carList;
    }

    public int tryCount() {
        return tryCount;
    }

    public List<RacingCar> start() {

        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : this.carList) {
                int randomValue = random();
                if (isMove(randomValue)) {
                    racingCar.go();
                }
            }
        }

        return this.carList;
    }


}
