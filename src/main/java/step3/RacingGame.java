package step3;

public class RacingGame {

    public void run() {
        RacingOption racingOption = InputView.getRacingOption();
        RacingTrack racingTrack = RacingTrack.of(racingOption);

        racingTrack.start();
        Cars cars = racingTrack.getCars();
        RacingGameResult result = RacingGameResult.makeResult(cars);
        ResultView.printGameResult(result);
    }
}
