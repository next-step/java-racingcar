package RacingCar;

import RacingCar.model.Result;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView.showInput();

        List<Result> results = RacingGame.getInstance().start();

        ResultView.print(results);
    }
}

