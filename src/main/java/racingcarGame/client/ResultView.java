package racingcarGame.client;

import racingcarGame.Car;
import java.util.List;

public class ResultView {
    public static void show(String message) {
        System.out.println(message);
    }

    public static void showResultGame() {
        show("실행 결과");
    }

    public static void showResult(List<Car> cars) {
        cars.forEach(car -> show(car.getPosition()));
        System.out.println();
    }
}
