package view;

import domain.RacingGameResult;

import java.util.List;

public class ResultView {

    public static void printGameResult(RacingGameResult racingGameResult) {
        System.out.println("\n실행 결과\n");
        racingGameResult.getResult()
                .stream()
                .forEach(round -> printRoundResult(round));
    }

    private static void printRoundResult(List<Integer> racingRound) {
        for (Integer position : racingRound) {
            printPosition(position);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }
}
