package racingcar;

import racingcar.dto.InputCars;
import racingcar.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        int number = InputView.inputNumber();
        int round = InputView.inputRound();

        RacingCar racingCar = new RacingCar(InputCars.fromNonEmptySize(number), round);
        List<RoundResult> result = racingCar.play(new RandomMovingStrategy());

        ResultView.print(result);
    }
}
