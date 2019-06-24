package step3;

import java.util.*;

public class RacingGameWinner {

    private static final int STRAIGHT = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private static List<Integer> carPositions = new ArrayList<>();
    private Random random = new Random();
    private ResultView resultView = new ResultView();
    private ValidationCheck validationCheck = new ValidationCheck();

    void setInitPosition(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carPositions.add(i, 0);
        }
        validationCheck.checkCarNumber(carNumber, carPositions.size());
    }

    void startRacing(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carPositions.set(i, carPositions.get(i) + move());
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

    void racingView(String[] carName) {
        resultView.racingView(carPositions, carName);
    }

    void findMaxScoreWinner(String[] carName) {
        resultView.findMaxScoreWinner(carPositions, carName);
    }
}