package racingcarGame.client;

import racingcarGame.model.Car;
import java.util.List;

public class ResultView {
    private static final String POSITION_STR = "-";

    public static void show(String message) {
        System.out.println(message);
    }

    public static void showGameResultTitle() {
        show("실행 결과");
    }

    public static void showResult(List<Car> cars) {
        cars.forEach(car -> {
            String movement = "";
            for (int i = 0; i < car.getPosition(); i++) {
                movement += POSITION_STR;
            }

            show(movement);
        });

        System.out.println();
    }
}
