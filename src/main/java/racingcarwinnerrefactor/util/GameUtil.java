package racingcarwinnerrefactor.util;

import racingcarwinnerrefactor.domain.ParticipatedCars;
import racingcarwinnerrefactor.domain.TryCount;
import racingcarwinnerrefactor.domain.WinnerCars;
import racingcarwinnerrefactor.view.ResultView;

public class GameUtil {

    private final TryCount tryCount;
    private final ParticipatedCars participatedCars;

    public GameUtil(TryCount tryCount, ParticipatedCars participatedCars) {
        this.tryCount = tryCount;
        this.participatedCars = participatedCars;
    }

    public void play() {
        ResultView.init();

        for (int i = 0; tryCount.isBiggerThan(i); i++) {
            participatedCars.moveAllCars();
            ResultView.printCurrentResult(participatedCars);
        }

        findWinner();
    }

    public void findWinner() {
        WinnerCars winnerCars = ObjectFactory.winnerCars();
        ResultView.printWinnerResult(winnerCars);
    }
}
