package racingcarGame.client;

import racingcarGame.Car;

public class ResultView {
    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }

    public static void resultGame() {
        show("실행 결과");
    }

    public static void showCarPosition(Car car) {
        show(car.getPosition());
    }
}
