package racingcar.view;

import racingcar.domain.round.Round;

import java.util.List;

public class OutputView {
    private static final String START_LINE = "|";
    private static final String CAR_POSITION = "-";

    public static void printPosition(int position) {
        System.out.print(START_LINE);
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }

    public static void printGameResult(List<Round> rounds) {
        System.out.println("실행 결과");

        for (Round round : rounds) {
            printRoundResult(round);
        }
    }

    public static void printRoundResult(Round round) {
        for (Integer position : round.getCars().getCarPositions()) {
            printPosition(position);
        }
        System.out.println();
    }
}
