package RacingCar;

import RacingCar.model.Result;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.showInput();

        List<Result> results = RacingGame.getInstance().start(inputView.getCar(), inputView.getStage());

        ResultView.print(results);
    }
}