package step2.racing_mvc.view;

import step2.racing_mvc.domain.RacingCar;
import step2.racing_mvc.domain.RacingCars;
import step2.racing_mvc.domain.RacingGameWinner;

public class ResultView {
    public static void showRace(RacingCars cars) {
        for (int i = 0; i < cars.count(); i++) {
            showOneCarMoveStatus(cars.findOne(i));
        }
        System.out.println();
    }

    private static void showOneCarMoveStatus(RacingCar car) {
        System.out.print(car.getName()+" : ");
        for (int j = 0; j < car.getPositionValue(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void start() {
        System.out.println("\n실행 결과");
    }

    public static void showWinners(RacingGameWinner winners) {
        System.out.print(winners.getNames()+"(이)가 최종 우승했습니다.");
    }
}