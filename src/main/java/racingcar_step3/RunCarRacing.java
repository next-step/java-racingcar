package racingcar_step3;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {
        CarRacingGame racingGame = new CarRacingGame();
        InputView inputView = new InputView();

        inputView.input();
        List<Integer> result = racingGame.createCars(inputView.getRacingCarCount());

        for (int i = 0; i < inputView.getRacingCount(); i++) {
            racingGame.runRacing(result);
            ResultView.viewRound(result);
        }
    }
}