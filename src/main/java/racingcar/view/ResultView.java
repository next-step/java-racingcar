package racingcar.view;

import racingcar.CarPosition;
import racingcar.CarPositions;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void print(List<CarPositions> results) {
        for (CarPositions result : results) {
            print(result);
        }

        String winners = String.join(",", results.get(results.size() - 1).getLeaders());
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
