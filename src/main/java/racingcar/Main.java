package racingcar;

import racingcar.race.Dice;
import racingcar.race.RacingRule;
import racingcar.race.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCountJoinRace();
        int raceTime = InputView.inputRaceTime();

        Dice dice = RacingDice.newInstance();
        RacingRule racingRule = new DiceRacingRule(dice);
        Racing race = new Racing(racingRule, carCount, raceTime);

        OutputView.printTitle();
        race.start(OutputView::printRaceResult);
    }
}
