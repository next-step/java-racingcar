package racingcar_step4;

import java.util.List;

public class ResultView {

    public static void viewRound(List<Car> cars) {

        for (Car car : cars) {
            int moveDistance = car.getTotalDistance();

            System.out.print(car.getCarName() + ": ");
            viewCarMoveInfo(moveDistance);

            System.out.println();
        }
        System.out.println();
    }

    private static void viewCarMoveInfo(int moveDistance) {
        for (int i = 0; i < moveDistance; i++) {
            System.out.print("-");
        }
    }

    public static void viewRacingCarWinners(List<Car> winners) {
        String winner = "";
        for (Car car : winners) {
            winner += car.getCarName() + ", ";
        }
        System.out.println(winner.substring(0, winner.length() - 2) + "가 최종 우승했습니다.");
    }
}
