package racing.ui;

import racing.car.Car;

public class ResultView {
    public static void showCurrentPosition(Car car) {
        for (int i = 0; i < car.position().position(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void nextAttempt() {
        System.out.println();
    }
}
