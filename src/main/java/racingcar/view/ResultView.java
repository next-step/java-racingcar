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

        String winners = String.join(",", moveResults.getWinners());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void print(CarPositions carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            print(carPositions.get(i));
        }

        System.out.println();
    }

    private static void print(CarPosition carPosition) {
        System.out.print(String.format("%s:", carPosition.getName()));

        for (int i = 0; i < carPosition.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
