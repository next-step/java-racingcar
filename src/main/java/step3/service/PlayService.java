package step3.service;

import java.util.List;
import step3.domain.ProceedPolicy;
import step3.domain.RacingGame;
import step3.domain.RacingHistories;

public class PlayService {

    private RacingGame racingGame;
    private final ProceedPolicy proceedPolicy;

    public PlayService(ProceedPolicy proceedPolicy) {
        this.proceedPolicy = proceedPolicy;
    }

    public void createGame(List<String> carNames) {
        racingGame = new RacingGame(carNames, proceedPolicy);
    }
    public RacingHistories playRacingGame(int tryCount) {
        racingGame.run(tryCount);

        return racingGame.getRacingHistories();
    }

}
