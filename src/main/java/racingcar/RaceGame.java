package racingcar;

import racingcar.domain.Race;
import racingcar.view.ResultView;
import racingcar.view.InputView;

public class RaceGame {
    public static void main(String[] args) {
        String[] carNames = InputView.inputNamesOfCars();
        int roundNum = InputView.inputRoundNum();

        Race race = new Race(carNames, roundNum);

        while(!race.isRaceOver()){
            race.runOneRound();
            ResultView.printCurrentState(race);
        }

        race.findWinners();
        ResultView.printGameOver(race);
    }
}
