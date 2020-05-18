package racingcar;

import racingcar.race.Dice;
import racingcar.race.RacingRule;
import racingcar.race.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.inputCarCountJoinRace();
        int raceTime = inputView.inputRaceTime();

        Dice dice = RacingDice.newInstance();
        RacingRule racingRule = new DiceRacingRule(dice);
        Racing race = new Racing(racingRule, carCount, raceTime);

        OutputView outputView = new OutputView();
        outputView.printTitle();
        race.start(gameResults -> {
            outputView.printRaceResult(gameResults);
        });
    }
}
