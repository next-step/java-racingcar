package step3;

import static step3.GameRule.*;

public class RacingCar {

    public static int[] moves;

    public static void main(String[] args) {
        int[] racingRule = InputView.input();
        moves = new int[racingRule[0]];

        ResultView.start();
        for (int i = 0; i < racingRule[1]; i++) {
            exeOneCycle(racingRule[0]);
            ResultView.cycleEnd();
        }
    }

    private static void exeOneCycle(int carNum) {
        for (int i = 0; i < carNum; i++) {
            moves[i] += decideMove(randomNum());
            ResultView.resultPrint(moves[i]);
        }
    }
}
