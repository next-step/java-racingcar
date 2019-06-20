package step3;

import java.util.Random;

public class RacingGameWinner {

    private static final int STRAIGHT = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private static int[] carPositions;
    private Random random = new Random();
    ValidationCheck validationCheck = new ValidationCheck();

    public void setInitPosition(int carNumber) {
        carPositions = new int[carNumber];
        validationCheck.checkCarNumber(carNumber, carPositions);
    }

    public void startRacing(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carPositions[i] += move();
        }
    }

    private int move() {
        int randomNum = random.nextInt(10);
        validationCheck.checkRandomValue(randomNum);

        if (randomNum >= STRAIGHT) {
            validationCheck.checkGo(randomNum);
            return GO;
        }
        return STOP;
    }

    public void resultView() {
        ResultView resultView = new ResultView();
        resultView.result(carPositions);
    }
}