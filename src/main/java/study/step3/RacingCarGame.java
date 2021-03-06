package study.step3;

import java.util.Random;

public class RacingCarGame {

    static final int MOVE_POSSIBLE_NUMBER = 4;

    public void start() {

        InputView inputView = new InputView();

        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        System.out.println("입력 한 자동차 대수는 : " + numberOfCars);
        System.out.println("입력 한 이동할 횟수는 : " + numberOfAttempts);
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public boolean movePossible(int number) {
        return number >= MOVE_POSSIBLE_NUMBER;
    }
}
