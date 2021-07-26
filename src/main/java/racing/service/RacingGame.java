package racing.service;

import racing.domain.*;
import racing.view.GameResultView;

public class RacingGame {

    private final RacingGamePlayPipe playPipe;

    private RacingGame(Cars cars, Count num) {
        playPipe = new RacingGamePlayPipe(cars, num);
    }

    public static RacingGame initialize(Players players, int countNumber) {
        return new RacingGame(new Cars(players), new Count(countNumber));
    }

    public GameResultView playGame() {
        playPipe.play();
        return playPipe.result();
    }

}
