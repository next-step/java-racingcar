package step3.service;

import java.util.List;
import step3.domain.ProceedPolicy;
import step3.domain.RacingGame;

public class PlayService {

    private final ProceedPolicy proceedPolicy;

    public PlayService(ProceedPolicy proceedPolicy) {
        this.proceedPolicy = proceedPolicy;
    }

    public List<String> playRacingGame(int carCount, int tryCount) {
        RacingGame racingGame = createGame(carCount, tryCount);
        racingGame.run();

        return racingGame.getRacingHistory();
    }

    private RacingGame createGame(int carCount, int tryCount) {
        return new RacingGame(carCount, tryCount, proceedPolicy);
    }
}
