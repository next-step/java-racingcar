package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingGameWinner {

    private static final int STRAIGHT = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private Map<String, Integer> racingScore = new HashMap<>();
    private Random random = new Random();
    ValidationCheck validationCheck = new ValidationCheck();

    public Map<String, Integer> connectPlayerToCar(String[] playerName, int carNumber) {

        for (int i = 0; i < carNumber; i++) {
            racingScore.put(playerName[i], 0);
        }
        validationCheck.checkCarNumber(carNumber, racingScore.size());
        return racingScore;
    }

//    public void setInitPosition(int carNumber) {
//        carPositions = new int[carNumber];
//        validationCheck.checkCarNumber(carNumber, carPositions);
//    }

    public void startRacingToSelectCar(Map<String, Integer > racingScore) {
        // 맵에서 하나씩 꺼내서 value를 업데이트
        for (int i = 0; i < racingScore.size(); i++) {
            racingScore.
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