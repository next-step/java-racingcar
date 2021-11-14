package step3.view;

import step3.domain.CarRacingGame;

import java.util.List;

public class OutputView {

    public static void printResult(CarRacingGame carRacingGame) {
        System.out.println("실행 결과");
        int totalRound = carRacingGame.getTotalRound();
        for (int round = 0; round < totalRound; round++) {
            printOneRoundResult(carRacingGame, round);
        }
    }

    private static void printOneRoundResult(CarRacingGame carRacingGame, int round) {
        List<Integer> positions = carRacingGame.getCarsPosition(round);
        for (int position : positions) {
            printCarPosition(position);
        }
        System.out.println();
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}