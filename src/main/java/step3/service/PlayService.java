package step3.service;

import java.util.List;
import step3.domain.ProceedPolicy;
import step3.domain.RacingGame;
import step3.domain.RacingHistories;

public class PlayService {

    private ProceedPolicy proceedPolicy;

    public PlayService(ProceedPolicy proceedPolicy) {
        this.proceedPolicy = proceedPolicy;
    }

    public List<String> playRacingGame(int carCount, int tryCount) {
        System.out.println("carCount = " + carCount);
        System.out.println("tryCount = " + tryCount);

        RacingGame racingGame = createGame(carCount, tryCount);
        racingGame.run();;

        return racingGame.getRacingHistory();
    }

    private RacingGame createGame(int carCount, int tryCount) {
        return new RacingGame(carCount, tryCount, proceedPolicy);
    }
}
