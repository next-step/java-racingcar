package racingcar;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String POSITION_BAR = "-";
    private static final int START_ROUND_NUMBER = 0;

    private int saveRound = 0;
    private Map<Integer, List<Racingcar>> roundResult = new HashMap<>();

    public void printResult() {
        System.out.println("실행 결과");
        for (int i = START_ROUND_NUMBER; i <= saveRound; i++) {
            printResultByRound(i);
        }
    }

    public void printRacingGameWinner(int round, List<Racingcar> carPositions) {

    }

    public void printResultByRound(int round) {
        try {
            List<Racingcar> carPositions = this.roundResult.get(round);
            printRacingCarPosition(round, carPositions);
        } catch (NullPointerException e) {
            throw new NullPointerException("실행되지 않은 라운드를 선택하였습니다.");
        }
    }

    private void printRacingCarPosition(int round, List<Racingcar> carPositions) {
        for (Racingcar racingcar : carPositions) {
            racingcar.printCarPrintRoundPosition(round, POSITION_BAR);
        }
        System.out.println();
    }

    public void saveRoundResult(int round, List<Racingcar> carPositions) {
        this.roundResult.put(round, carPositions);
        this.saveRound = round;
    }
}
