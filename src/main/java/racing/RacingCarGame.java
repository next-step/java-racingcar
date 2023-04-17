package racing;

import java.util.List;

public class RacingCarGame {

    public static void start() {
        InputView.input();
        List<String> names = stringToNameList();
        Cars cars = new Cars(names, InputView.moveCount());

        ResultView.printTitle();
        progress(cars);
        ResultView.showWinner(cars);
    }

    private static List<String> stringToNameList() {
        return List.of(InputView.carNames().split(","));
    }

    public static void progress(Cars cars) {
        for (int i = 0; i < cars.moveCount(); i++) {
            cars = cars.move();
            ResultView.printRace(cars);
        }
    }

}
