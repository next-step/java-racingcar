package racingcar.ui;

import racingcar.domain.Position;
import racingcar.domain.Positions;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";
    public static final String EXECUTE_RESULT = "실행 결과";

    public static void print(List<Positions> gameResult) {
        System.out.println(EXECUTE_RESULT);

        for (Positions roundResult : gameResult) {
            printPositionsPerRound(roundResult);
            System.out.println();
        }
    }

    private static void printPositionsPerRound(Positions positions) {
        for (Position position : positions.getPositions()) {
            printPosition(position);
            System.out.println();
        }
    }

    private static void printPosition(Position position) {
        System.out.print(DASH.repeat(position.getValue()));
    }

}
