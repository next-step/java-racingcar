package view;

import domain.RacingCarPosition;
import domain.RacingGameResult;

import java.util.List;

public class ResultView {

    private static final String COMMA_BLANK_SPLITTER = ", ";

    public static void printGameResult(RacingGameResult racingGameResult) {
        System.out.println("\n실행 결과\n");
        racingGameResult.getRoundProgress()
                .forEach(ResultView::printRoundResult);
        printWinners(racingGameResult.getLastWinners());
    }

    private static void printRoundResult(List<RacingCarPosition> racingRound) {
        for (RacingCarPosition position : racingRound) {
            printPosition(position);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(RacingCarPosition position) {
        System.out.print(position.getName() + " : ");
        for (int i = 0; i < position.getLocationPoint(); i++) {
            System.out.print('-');
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.println("\n");
        System.out.println(String.join(COMMA_BLANK_SPLITTER, winners) + "가 최종 우승했습니다.");
    }
}
