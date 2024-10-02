package javaracingcar;

import javaracingcar.entity.RacingCar;
import javaracingcar.entity.RacingCarStepEnum;
import javaracingcar.view.InputView;
import javaracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaRacingCar {

    private static final int RANDOM_VALUE_RANGE = 10;
    private static final int DEFAULT_TRY_COUNT_VALUE = 0;

    private final Random random = new Random();
    private final List<RacingCar> cars = new ArrayList<>();

    private int tryCount = DEFAULT_TRY_COUNT_VALUE;
    private RacingCarStepEnum step = RacingCarStepEnum.INIT;

    public JavaRacingCar() {
        requireCarCount(InputView.requireCarCount());
        requireTryCount(InputView.requireTryCount());
        start();
    }

    public void requireCarCount(int carCount) throws RuntimeException {
        validateNegativeNumber(carCount);
        initCars(carCount);
        this.step = RacingCarStepEnum.CONFIRMED_CAR_COUNT;
    }

    public void requireTryCount(int tryCount) throws RuntimeException {
        validateNegativeNumber(tryCount);
        this.step = RacingCarStepEnum.CONFIRMED_TRY_COUNT;
        this.tryCount = tryCount;
    }

    public List<RacingCar> start() {
        ResultView.resultStartMessage();
        for (int i = 0; i < this.tryCount; i++) {
            startRound();
        }
        return this.cars;
    }

    public int random() {
        return random.nextInt(RANDOM_VALUE_RANGE);
    }

    private void validateNegativeNumber(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    private void initCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar());
        }
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

    public int tryCount() {
        return this.tryCount;
    }

    public RacingCarStepEnum step() {
        return this.step;
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

}
