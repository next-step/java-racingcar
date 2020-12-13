package study.racingcar;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int racingParticipant = inputView.inputRacingParticipant();
        int tryNo = inputView.inputTryNo();

        RacingContest racingContest = new RacingContest(racingParticipant, tryNo);

        while (racingContest.isPlaying()) {
            racingContest.play();
            RacingResult racingResult = racingContest.gerResult();
            outputView.printRacingResult(racingResult);

        }

    }
}
