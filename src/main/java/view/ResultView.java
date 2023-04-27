package view;

import domain.Car;
import domain.Cars;
import domain.Winner;

public class ResultView {
    public static void showRace(Cars cars) {
        for (int i = 0; i < cars.count(); i++) {
            showOneCarMoveStatus(cars.findOne(i));
        }
        System.out.println();
    }

    private static void showOneCarMoveStatus(Car car) {
        System.out.print(car.getName()+" : ");
        for (int j = 0; j < car.getPositionValue(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void start() {
        System.out.println("\n실행 결과");
    }

    public static void showWinners(Winner winners) {
        System.out.print("최종 우승자는 " + winners.getNames());
    }
}