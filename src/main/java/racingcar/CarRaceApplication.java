package racingcar;

import racingcar.domain.CarRace;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class CarRaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        CarRace carRace = new CarRace(inputView.getCarNames(), inputView.getRunCount());
        resultView.print(carRace.run());
        resultView.printWinners(carRace.findWinners());
    }


}
