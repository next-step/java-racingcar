package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingCarMain {
    public static void main(String[] args) {
        int number = InputView.inputNumber();
        int round = InputView.inputRound();

        RacingCar racingCar = new RacingCar(number, round);
        ArrayList<Cars> result = racingCar.play();

        for (Cars cars : result) {
            ResultView.print(cars.states());
        }
    }
}
