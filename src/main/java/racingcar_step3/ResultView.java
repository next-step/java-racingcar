package racingcar_step3;

import java.util.List;

public class ResultView {

    public static void viewRound(List<Integer> cars) {
        for (int car : cars) {
            viewCarMoveInfo(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void viewCarMoveInfo(int moveDistance) {
        for (int i = 0; i < moveDistance; i++) {
            System.out.print("-");
        }
    }
}
