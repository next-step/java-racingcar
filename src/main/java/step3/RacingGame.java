package step3;

public class RacingGame {

    public void run() {
        UserInput userInput = InputView.getRacingOption();
        RacingOption racingOption = RacingOption.from(userInput);
        RacingTrack racingTrack = RacingTrack.of(racingOption);

        for (int round = 0; round < racingOption.getNumberOfRounds(); round++) {
            RacingGameResult gameResult = racingTrack.start();
            ResultView.printGameResult(round, gameResult);
        }
    }
}
