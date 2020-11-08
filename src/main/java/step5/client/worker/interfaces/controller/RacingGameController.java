package step5.client.worker.interfaces.controller;

import step5.client.worker.interfaces.presenter.ResultViewPresenter;
import step5.client.worker.application.RacingGameResponse;
import step5.client.worker.application.RacingGameInteractor;
import step5.client.worker.application.RacingGameRequest;

public class RacingGameController {
    private static final RacingGameInteractor INTERACTOR = new RacingGameInteractor();
    private static final ResultViewPresenter PRESENTER = new ResultViewPresenter();

    public String showSimulationResult(final String carNames, final String times) {
        final RacingGameRequest request = RacingGameRequest.of(carNames, times);
        final RacingGameResponse response = INTERACTOR.interact(request);
        return PRESENTER.present(response);
    }
}