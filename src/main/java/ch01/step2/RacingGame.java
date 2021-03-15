package ch01.step2;

import java.util.Random;

public class RacingGame {

    int attemptCount = 0;
    int carCount = 0;
    String[] progressArr;

    void execute() {
        InputView iv = new InputView();
        this.attemptCount = iv.getAttemptCount();
        this.carCount = iv.getCarCount();
        this.progressArr = iv.getProgressArr();
        ResultView rv = new ResultView(progressArr);
        System.out.println("실행결과");
        while (attemptCount-- > 0) {
            racing();
            rv.print();
        }


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

    public boolean isKeepGoing(int randomNumber) {
        return randomNumber > 3;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static void main(String[] args) {
        new RacingGame().execute();
    }
}
