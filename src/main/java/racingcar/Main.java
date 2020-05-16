package racingcar;

import racingcar.race.Dice;
import racingcar.race.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.inputCarCountJoinRace();
        int raceTime = inputView.inputRaceTime();

        Dice dice = new RacingDice(RacingDice.RACING_MAX_BOUND);
        Racing race = new Racing(dice, raceTime);
        race.joinRace(carCount);

        OutputView outputView = new OutputView();
        outputView.printTitle();
        race.start(gameResults -> {
            outputView.printRaceResult(gameResults);
        });
    }
}
