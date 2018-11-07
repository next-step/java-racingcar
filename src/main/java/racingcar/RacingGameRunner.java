package racingcar;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        RacingGameOption option = InputView.inputRacingGameOption();

        int numberOfTimes = option.getNumberOfTimes();
        List<RacingCar> racingCars = RacingCar.create(option.getRacingCarNames());

        RacingGame racingGame = new RacingGame();
        List<RacingGameResultSet> racingGameResultSets = racingGame.startRace(numberOfTimes, racingCars);

        ResultView.showRacingGameResult(racingGameResultSets);
    }
}
