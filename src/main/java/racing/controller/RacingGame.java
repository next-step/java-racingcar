package racing.controller;

import racing.domain.CarMovableStrategy;
import racing.domain.Cars;
import racing.service.RacingGameService;
import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingGame {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        String[] carNames = inputView.enterCarName();
        int tryCount = inputView.enterTryCount();

        RacingGameService racingGameService = new RacingGameService();

        Cars cars = racingGameService.prepare(carNames);

        racingGameService.racing(cars, tryCount, resultView, new CarMovableStrategy());
    }

}
