package racingcar_step3;

import java.util.List;

public class RunCarRacing {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.input();

        Car car = new Car(inputView.getRacingCarCount(), inputView.getRacingCount());

        CarRacingGame racingGame = new CarRacingGame(car);
        racingGame.runRacing();
        List<Integer> result = racingGame.getRacingPositions();

        ResultView resultView = new ResultView();
        resultView.print(result);
    }
}