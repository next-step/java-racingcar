package step5.client.worker.interfaces.controller;

import step5.client.worker.interfaces.presenter.ResultViewPresenter;
import step5.client.worker.application.SimulationResponse;
import step5.client.worker.application.SimulationResponseInteractor;
import step5.client.worker.application.SimulationRequest;

public class RacingGameController {
    private static final SimulationResponseInteractor INTERACTOR = new SimulationResponseInteractor();
    private static final ResultViewPresenter PRESENTER = new ResultViewPresenter();

    public String showSimulationResult(final String carNames, final String times) {
        final SimulationRequest request = SimulationRequest.of(carNames, times);
        final SimulationResponse response = INTERACTOR.interact(request);
        return PRESENTER.present(response);
    }
}