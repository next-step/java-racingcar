package RacingCar;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView.showInput();

        List<List<Integer>> results = RacingGame.getInstance().start();

        ResultView.print(results);
    }
}

