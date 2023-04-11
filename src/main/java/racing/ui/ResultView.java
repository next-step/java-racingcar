package racing.ui;

import racing.Car;

import java.util.ArrayList;

public class ResultView {
    public static void showRace(ArrayList<Car> cars) {
        for (Car car : cars) {
            showRaceOneCar(car);
        }
        System.out.println();
    }

    private static void showRaceOneCar(Car car) {
        for (int j = 0; j < car.status; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void start() {
        System.out.println("\n실행 결과");
    }
}
