package view;

import domain.RacingCarPosition;
import domain.RacingGameResult;

import java.util.List;

public class ResultView {

    public static void printGameResult(RacingGameResult racingGameResult) {
        System.out.println("\n실행 결과\n");
        racingGameResult.getResult()
                .stream()
                .forEach(round -> printRoundResult(round));
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
}
