package step5.client.worker.interfaces.controller;

import step5.client.worker.domain.RacingGame;
import step5.client.worker.domain.strategy.RandomMovableStrategy;
import step5.client.worker.interfaces.presenter.ResultViewPresenter;
import step5.client.worker.domain.RacingGameCondition;

public class RacingGameController {
    private static final ResultViewPresenter PRESENTER = new ResultViewPresenter();

    public String showSimulationResult(final String carNames, final String times) {
        final RacingGameCondition condition = RacingGameCondition.of(carNames, times);
        final RacingGame racingGame  = RacingGame.of(condition.getCarNames(), new RandomMovableStrategy());
        racingGame.race(condition.getTryNumber());
        return PRESENTER.present(racingGame.getRacingGameResponse());
    }
}