package racingcar;

import racingcar.controller.RacingCar;
import racingcar.dto.InputCars;
import racingcar.dto.ResultCars;
import racingcar.dto.RoundResult;
import racingcar.model.CarName;
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

        if (!result.isEmpty()) {
            RoundResult roundResult = result.get(result.size() - 1);
            ResultCars resultCars = ResultCars.of(roundResult.getCarsCount(), roundResult.getCarNames(), roundResult.getDistances());
            List<CarName> winners = resultCars.value().findWinnerCarNames();
            ResultView.printWinner(winners);
        }
    }
}
