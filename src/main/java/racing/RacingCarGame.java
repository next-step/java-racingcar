package racing;

import java.util.List;

public class RacingCarGame {

    private static int round = 0;

    public static void start() {
        InputView.input();
        List<String> names = stringToNameList();
        progress(new Cars(names, InputView.moveCount()));
    }

    private static List<String> stringToNameList() {
        return List.of(InputView.carNames().split(","));
    }

    public static void progress(Cars cars) {
        for (int i = 0; i < cars.moveCount(); i++) {
            cars = cars.move();
            ResultView.print(cars);
            round += 1;
        }
    }

    public static int getRound() {
        return round;
    }

}
