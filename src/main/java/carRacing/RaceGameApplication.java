package carRacing;

import carRacing.model.RacingCarFactory;
import carRacing.model.RacingCarGroup;
import carRacing.model.RacingGame;
import carRacing.model.RandomGamePoint;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RaceGameApplication {

    public static void main(String[] args) {

        String[] inputRaceCars = InputView.inputRaceCars();
        int numberOfRaceLaps= InputView.inputNumberOfLaps();

        RacingCarFactory racingCarFactory = new RacingCarFactory(inputRaceCars);
        RacingGame racingGame = new RacingGame(racingCarFactory.manufacture(), new RandomGamePoint());

        for (int lap = 0; lap < numberOfRaceLaps; lap++) {
            RacingCarGroup racingCars = racingGame.race();
            ResultView.printRacingMiddleResult(racingCars);
        }
        RacingCarGroup racingWinners = racingGame.gameResult();
        ResultView.printWinners(racingWinners);

    }
}
