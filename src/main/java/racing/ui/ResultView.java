package racing.ui;

import racing.Car;
import racing.Cars;

public class ResultView {
    public static void showRace(Cars cars) {
        for (int i = 0; i < cars.count(); i++) {
            showOneCarMoveStatus(cars.find(i));
        }
        System.out.println();
    }

    private static void showOneCarMoveStatus(Car car) {
        for (int j = 0; j < car.moveStatus; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void start() {
        System.out.println("\n실행 결과");
    }
}
