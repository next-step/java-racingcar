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

    /* 전진 여부 로직 */
    private void go () {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(10);

        if (randomNumber >= 4) {
            ResultView.printForwardLine();
        }
    }
}