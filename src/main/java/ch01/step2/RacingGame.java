package ch01.step2;

import java.util.Random;

public class RacingGame {

    int attemptCount = 0;
    int carCount = 0;
    String[] progressArr;

    public RacingGame() {
        execute();
    }

    public void racing() {
        int randomNumber = 0;
        int progressArrSize = progressArr.length;
        for (int i = 0; i < progressArrSize; i++) {
            randomNumber = getRandomNumber();
            moveCar(progressArr, i, isKeepGoing(randomNumber));
        }
    }

    public void moveCar(String[] progressArr, int index, boolean isKeepGoing) {
        if (isKeepGoing && progressArr[index] != null) {
            progressArr[index] += "-";
        }

        if (isKeepGoing && progressArr[index] == null) {
            progressArr[index] = "-";
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public int getAttemptCount(){
        return this.attemptCount;
    }

    public boolean isKeepGoing(int randomNumber) {
        return randomNumber > 3;
    }

    private void execute() {
        InputView iv = new InputView();
        InputData inputData = iv.getInputData();

        this.attemptCount = inputData.getAttemptCount();
        this.carCount = inputData.getCarCount();
        this.progressArr = inputData.getProgressArr();

        ResultView rv = new ResultView(progressArr);
        rv.showResult(this);
    }


    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
    }


}
