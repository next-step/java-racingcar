package racing;

import static racing.RacingGame.carMove;

public class ResultView {
    static void printResult(int carCount, int tryCount, String[] carPosition) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                System.out.println(carPosition[j]);
                carMove(carPosition, j);
            }
            System.out.println();
        }
    }


}
