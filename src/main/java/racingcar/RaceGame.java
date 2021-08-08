package racingcar;

import racingcar.domain.Race;
import racingcar.view.ResultView;
import racingcar.view.InputView;

public class RaceGame {
    public static void main(String[] args) {
        String[] carNames = InputView.inputNamesOfCars();
        int roundNum = InputView.inputRoundNum();

        Race race = new Race(carNames, roundNum);

        do {
            race.runOneRound();
            ResultView.printCurrentState(race);
        } while (!race.isRaceOver());

        ResultView.printGameOver(race);
    }
}
