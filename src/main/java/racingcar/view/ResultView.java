package racingcar.view;

import racingcar.CarPosition;
import racingcar.CarPositions;
import racingcar.MoveResults;

public class ResultView {

    private ResultView() {
    }

    public static void print(MoveResults moveResults) {
        for (int i = 0; i < moveResults.size(); i++) {
            print(moveResults.get(i));
        }
    }

    private static void print(CarPositions carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            System.out.print(":");
            print(carPositions.get(i));
        }

        System.out.println();
    }

    private static void print(CarPosition carPosition) {
        for (int i = 0; i < carPosition.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
