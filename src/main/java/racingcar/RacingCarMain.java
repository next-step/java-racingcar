package racingcar;

import java.util.ArrayList;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCar racingCar = new RacingCar(inputView.number(), inputView.round());

        ArrayList<ArrayList<Integer>> result = racingCar.play();

        resultView.print(result);
    }
}
