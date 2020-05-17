package racingcar_step3;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.input();

        CarRacingGame racingGame = new CarRacingGame(inputView.getRacingCarCount(), inputView.getRacingCount());
        racingGame.initValue();
        racingGame.move();
        List<Integer> result = racingGame.getCarPositions();

        ResultView resultView = new ResultView();
        resultView.print(result);
    }
}