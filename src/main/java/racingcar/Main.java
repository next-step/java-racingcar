package racingcar;

import racingcar.race.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String name = InputView.inputCarCountJoinRace();
        int raceTime = InputView.inputRaceTime();

        List<Car> carList = RacingRegistry.getCarList(name);
        Racing race = Racing.applyRacing(carList, raceTime);

        OutputView.printTitle();
        race.start(OutputView::printRaceResultByTime);
        OutputView.printWinner(race.getWinnerAfterFinalRacing());
    }
}
