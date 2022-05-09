package racingcarwinnerrefactor.util;

import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.TryCount;
import racingcarwinnerrefactor.domain.WinnerCars;
import racingcarwinnerrefactor.view.ResultView;

public class GameController {

    private final TryCount tryCount;
    private final ParticipatedCars participatedCars;
    private static GameController gameController;

    public static GameController gameControllerFactory(TryCount tryCount, ParticipatedCars participatedCars) {
        if(gameController == null)  gameController = new GameController(tryCount, participatedCars);
        return gameController;
    }

    private GameController(TryCount tryCount, ParticipatedCars participatedCars) {
        this.tryCount = tryCount;
        this.participatedCars = participatedCars;
    }

    public void play() {
        ResultView.init();

        int count = tryCount.getCount();

        for (int i = 0; i < count ; i++) {
            participatedCars.moveAllCars();
            ResultView.printCurrentResult(participatedCars);
        }

        findWinner();
    }

    public void findWinner() {
        WinnerCars winnerCars = new WinnerCars(participatedCars);
        ResultView.printWinnerResult(winnerCars);
    }
}
