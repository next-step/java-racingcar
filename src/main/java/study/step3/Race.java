package study.step3;

import java.util.Random;

/*
 * Race
 *
 * 1.0.0
 *
 * 2020-11-08
 */
public class Race {
    int carCount;
    int raceCount;

    public Race() {
        InputView inputView = new InputView();

        this.carCount = inputView.inputCarCount();
        this.raceCount = inputView.inputRacingCount();
    }
}