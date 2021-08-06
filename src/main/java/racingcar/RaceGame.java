package racingcar;

import racingcar.domain.Race;
import racingcar.view.ResultView;
import racingcar.view.StartView;

public class RaceGame {
    public static void main(String[] args) {
        int carNum;
        int roundNum;

        carNum = StartView.inputCarNum();
        roundNum = StartView.inputRoundNum();

        Race race = new Race(carNum, roundNum);

        do {
            race.runOneRound();
            ResultView.printCurrentState(race, race.getCars());
        } while (!race.isRaceOver());

        ResultView.printGameOver();
    }
}
