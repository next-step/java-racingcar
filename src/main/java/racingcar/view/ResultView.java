package racingcar.view;

import racingcar.domain.RacingGame;
import racingcar.domain.Racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final int START_ROUND_NUMBER = 0;

    private RacingGame racingGame;
    private int saveRound = 0;

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printResult() {
        System.out.println("실행 결과");
        for (int i = START_ROUND_NUMBER; i < saveRound; i++) {
            printResultByRound(i);
        }
    }

    public void printRacingGameWinner() {
        List<String> winnerNames = new ArrayList<>();
        for (Racingcar racingcar : racingGame.getWinners()) {
            winnerNames.add(racingcar.getCarName());
        }
        String printStr = String.join(", ", winnerNames);
        System.out.println(printStr + "가 최종 우승했습니다.");
    }

    public void printResultByRound(int round) {
        try {
            Map<Integer, List<Racingcar>> roundResult = racingGame.getRoundResult();
            List<Racingcar> carPositions = roundResult.get(round);
            printRacingCarPosition(round, carPositions);
        } catch (NullPointerException e) {
            throw new NullPointerException("실행되지 않은 라운드를 선택하였습니다.");
        }
    }

    private void printRacingCarPosition(int round, List<Racingcar> carPositions) {
        for (Racingcar racingcar : carPositions) {
            racingcar.printCarRoundPosition(round);
        }
        System.out.println();
    }
}
