package step3and4.ui;

import step3and4.Racing;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private final Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }

    public void startGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < racing.getTryNumber(); i++) {
            racing.tryMove();
            List<String> carNames = racing.getNames();
            int[] moveResult = racing.createMoveResult();
            createResult(carNames, moveResult);
        }
        createWinCars(racing.getWinCars());
    }

    private void createWinCars(List<String> winCars) {
        System.out.println(String.join(",", winCars) + "최종 우승했습니다.");
    }

    private static void createResult(List<String> carNames, int[] moveResult) {
        int length = carNames.size();
        for (int i = 0; i < length; i++) {
            createCarName(carNames.get(i));
            createHyphen(moveResult[i]);
        }
        System.out.println();

    }

    private static void createCarName(String carNames) {
        System.out.print(carNames + ":");
    }

    private static void createHyphen(int moveResult) {
        for (int j = 0; j < moveResult; j++) {
            System.out.printf("-");
        }
        System.out.println();
    }
}
