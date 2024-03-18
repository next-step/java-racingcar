package racingcar.view;

import racingcar.domain.dto.RacingResult;
import racingcar.domain.dto.RoundResult;
import racingcar.domain.dto.RoundScore;

public class OutputView {
    private static final String POSITION_DELIMITOR = "-";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarsPositionByRounds(RacingResult rounds) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : rounds.getRoundResults()) {
            printCarsPositionByOneRound(roundResult);
        }
        System.out.println();
    }

    public static void printCarsPositionByOneRound(RoundResult roundResult) {
        for (RoundScore roundScore : roundResult.getRoundScores()) {
            printCarPosition(roundScore.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int positionNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionNumber; i++) {
            stringBuilder.append(POSITION_DELIMITOR);
        }
        System.out.println(stringBuilder);
    }
}
