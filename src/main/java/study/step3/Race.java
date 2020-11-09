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

    /* 시작 */
    public void start() {
        for (int i = 0; i < this.raceCount; i++) {
            loopByCarCount();
        }
        ResultView.printCrlf();
    }

    /* 자동차 수만큼 시도 로직 반복 */
    private void loopByCarCount() {
        for (int i = 0; i < this.carCount; i++) {
            loopByRaceCount();
        }
        ResultView.printCrlf();
    }

    /* 시도 회수만큼 전진 로직 반복 */
    private void loopByRaceCount() {
        for (int i = 0; i < this.raceCount; i++) {
            go();
        }
        ResultView.printCrlf();
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

    /* 임시 테스트 */
    public static void main(String[] args) {
        Race race = new Race();

        race.start();
    }
}