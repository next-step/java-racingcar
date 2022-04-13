package racingcar;

import racingcar.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        int number = InputView.inputNumber();
        int round = InputView.inputRound();

        RacingCar racingCar = new RacingCar(number, round);
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        List<RoundResult> result = racingCar.play(randomMovingStrategy);

        ResultView.print(result);
    }
}
