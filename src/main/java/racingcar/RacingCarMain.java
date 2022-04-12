package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingCarMain {
    public static void main(String[] args) {

        int number = InputView.inputNumber();
        int round = InputView.inputRound();
        ResultView resultView = new ResultView();
        RacingCar racingCar = new RacingCar(number, round);

        ArrayList<ArrayList<Integer>> result = racingCar.play();

        resultView.print(result);
    }
}
