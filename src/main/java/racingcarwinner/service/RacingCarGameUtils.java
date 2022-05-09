package racingcarwinner.service;

import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.domain.WinnerCars;
import racingcarwinner.view.OutputView;

public class RacingCarGameUtils {
    private final TryCount tryCount;

    public RacingCarGameUtils(TryCount tryCount) {
        this.tryCount = tryCount;

    }

    public void play(ParticipatedCars participatedCars) {
        OutputView.print();
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            participatedCars.moveAllCars();
            OutputView.printGameResult(participatedCars);
        }

        WinnerCars winnerCars = new WinnerCars(participatedCars);
        OutputView.printWinnerResult(winnerCars);
    }

}
