package step4;

public class RacingGame {

    public void run() {
        UserInput userInput = InputView.getRacingOption();
        RacingOption racingOption = RacingOption.from(userInput);
        RacingTrack racingTrack = RacingTrack.of(racingOption);

        for (int round = 1; round <= racingOption.getNumberOfRounds(); round++) {
            RacingGameResult gameResult = racingTrack.start();
            ResultView.printGameResult(round, isFinalRound(round, racingOption.getNumberOfRounds()), gameResult);
        }
    }

    private boolean isFinalRound(int round, int maxRound) {
        return round == maxRound;
    }
}
