package racingcar.application;

import racingcar.domain.CarRace;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class CarRaceApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        List<String> carNames = input.getCarNames();
        int runCount = input.getRunCount();

        CarRace carRace = new CarRace(carNames, runCount);
        List<List<Integer>> result = carRace.run();

        ResultView output = new ResultView();
        output.print(result);
    }
}
