package racingcar;

import racingcar.domain.Race;
import racingcar.view.ResultView;
import racingcar.view.InputView;

public class RaceGame {
    public static void main(String[] args) {
        String[] carNames = InputView.inputNameOfCars();
        int roundNum = InputView.inputRoundNum();

        Race race = new Race(carNames, roundNum);

        do {
            race.runOneRound();
            ResultView.printCurrentState(race, race.getCars());
        } while (!race.isRaceOver());

        ResultView.printGameOver();
    }
}
