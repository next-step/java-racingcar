package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResultSet;
import racingcar.dto.RacingGameOption;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        RacingGameOption option = InputView.inputRacingGameOption();

        int numberOfTimes = option.getNumberOfTimes();
        List<RacingCar> racingCars = RacingCar.create(option.getRacingCarNames());

        RacingGame racingGame = new RacingGame();
        List<RacingGameResultSet> racingGameResultSets = racingGame.startRace(numberOfTimes, racingCars);

        ResultView.showRacingGameResult(racingGameResultSets);
    }
}
