package study03;

import study03.view.InputView;
import study03.view.RacingView;

import java.util.stream.IntStream;

public class RacingGame {

    public RacingGame() {
        InputView inputView = new InputView();
        RacingView racingView = new RacingView();
        int racingCarCount = inputView.inputRacingCar();
        int tryCount = inputView.inputTryCount();

        Track track = new Track();
        track.addRacingCar(racingCarCount);

        racingView.racingStart();

        for (int i = 0 ; i < tryCount ; i++) {
            track.moveAll();
            racingView.printRacingResult(track);
        }
    }

    public static void main(String[] args) {
        new RacingGame();
    }

}
