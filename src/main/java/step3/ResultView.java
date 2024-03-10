package step3;

import java.util.Arrays;

public class ResultView {

    private final Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }

    public void startGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < racing.getTryNumber(); i++) {
            racing.tryMove();
            int[] moveResult = racing.createMoveResult();
            createHyphen(moveResult);
            System.out.println();
        }
    }

    private static void createHyphen(int[] moveResult) {
        Arrays.stream(moveResult).forEach(item -> {
            for (int j = 0; j < item; j++) {
                System.out.printf("-");
            }
            System.out.println();
        });
    }
}
