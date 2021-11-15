package study04;

import study04.racing.RacingTrack;
import study04.view.InputView;
import study04.view.RacingView;

import java.util.List;

public class RacingGame {

    public RacingGame() {
        InputView inputView = new InputView();
        RacingView racingView = new RacingView();
        List<String> racingCarNames = inputView.inputRacingCar();
        int tryCount = inputView.inputTryCount();

        RacingTrack racingTrack = RacingTrack.createRacingTrack(racingCarNames);

        racingView.racingStart();

        for (int i = 0 ; i < tryCount ; i++) {
            racingTrack.run();
            racingView.printRacingStatus(racingTrack, racingCarNames);
        }

        racingView.printRacingWinner(racingTrack.findWinnerOfRace());
    }

    public static void main(String[] args) {
        new RacingGame();
    }

}
