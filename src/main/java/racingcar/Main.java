package racingcar;

import racingcar.race.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        String name = InputView.inputCarCountJoinRace();
        int raceTime = InputView.inputRaceTime();

        Racing race = Racing.applyRacing(name, raceTime);

        OutputView.printTitle();
        race.start(OutputView::printRaceResultByTime);
        OutputView.printWinner(race.getWinner());
    }
}
