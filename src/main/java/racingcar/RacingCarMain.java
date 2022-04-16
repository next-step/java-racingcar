package racingcar;

import racingcar.controller.RacingCar;
import racingcar.dto.InputCars;
import racingcar.dto.RoundResult;
import racingcar.model.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        String carsInfo = InputView.inputCarsInfo();
        int round = InputView.inputRound();

        RacingCar racingCar = new RacingCar(InputCars.fromCarsInfo(carsInfo), round);
        List<RoundResult> result = racingCar.play(new RandomMovingStrategy());

        ResultView.print(result);
    }
}
