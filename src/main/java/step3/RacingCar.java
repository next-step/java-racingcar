package step3;

import static step3.GameRule.*;

public class RacingCar {

    public static int[] moves;

    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int tryNum = InputView.inputTryNum();
        moves = new int[carNum];

        ResultView.start();
        for (int i = 0; i < tryNum; i++) {
            exeOneCycle(carNum);
            ResultView.cycleEnd();
        }
    }

    private static void exeOneCycle(int carNum) {
        for (int i = 0; i < carNum; i++) {
            moves[i] += decideMove(createRandomNum());
            ResultView.resultPrint(moves[i]);
        }
    }
}
