package racing.controller;

import racing.domain.CarMovableStrategy;
import racing.domain.Cars;
import racing.service.RacingGameService;
import racing.service.RacingGameServiceImpl;
import racing.ui.InputView;

public class RacingGame {

    private final InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int entryCount = inputView.enterCarCount();
        int tryCount = inputView.enterTryCount();

        RacingGameService racingGameService = new RacingGameServiceImpl(entryCount, tryCount);
        Cars cars = racingGameService.prepare();
        racingGameService.racing(cars, new CarMovableStrategy());
    }

}
