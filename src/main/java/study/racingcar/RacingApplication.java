package study.racingcar;

import study.racingcar.controller.RacingContest;
import study.racingcar.dto.RacingResult;
import study.racingcar.dto.WinnerResults;
import study.racingcar.view.InputView;
import study.racingcar.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String racingParticipantByName = inputView.inputRacingParticipantByName();
        int tryNo = inputView.inputTryNo();

        RacingContest racingContest = new RacingContest(racingParticipantByName, tryNo);
        while (racingContest.isPlaying()) {
            racingContest.play();
            RacingResult racingResult = racingContest.gerResult();
            outputView.printRacingResult(racingResult);
        }

        WinnerResults winners = racingContest.findWinners();
        outputView.printWinner(winners);
    }
}
