package com.kimdahyeee.racing;

import com.kimdahyeee.racing.view.InputView;
import com.kimdahyeee.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RacingGame {
    private static final int TIME_TO_SLEEP = 1;
    private int tryCount;
    private List<Integer> carPositions;

    public RacingGame() {
        initCarCountAndPositions();
        initTryCount();
    }

    private void initCarCountAndPositions() {
        int carCount = InputView.getCarCount();
        carPositions = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carPositions.add(0);
        }
    }

    private void initTryCount() {
        tryCount = InputView.getTryCount();
    }

    public void start() {
        Car car = new Car();
        ResultView.printHeader();

        for (int i = 0; i < tryCount; i++) {
            carPositions = car.move(carPositions);
            ResultView.print(carPositions);
            sleepOneSecondForPrint();
        }
    }

    private void sleepOneSecondForPrint() {
        try {
            TimeUnit.SECONDS.sleep(TIME_TO_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException("timeUnit 오류 : ", e);
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
