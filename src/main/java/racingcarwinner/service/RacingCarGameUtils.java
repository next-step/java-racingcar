package racingcarwinner.service;

import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.TryCount;
import racingcarwinner.domain.WinnerCars;
import racingcarwinner.view.OutputView;

public class RacingCarGameUtils {
    private final TryCount tryCount;
    private OutputView outputView;

    public RacingCarGameUtils(TryCount tryCount) {
        this.tryCount = tryCount;
        outputView = new OutputView();
    }

    public void play(ParticipatedCars participatedCars) {
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            participatedCars.moveAllCars();
            outputView.printGameResult(participatedCars);
        }

        WinnerCars winnerCars = new WinnerCars(participatedCars);
        outputView.printWinnerResult(winnerCars);
    }




}
