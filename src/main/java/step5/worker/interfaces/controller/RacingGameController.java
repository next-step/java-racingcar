package step5.worker.interfaces.controller;

import step5.worker.interfaces.presenter.ResultViewPresenter;
import step5.worker.application.SimulationResponse;
import step5.worker.application.SimulationResponseInteractor;
import step5.worker.application.SimulationRequest;

public class RacingGameController {
    private static final SimulationResponseInteractor INTERACTOR = new SimulationResponseInteractor();
    private static final ResultViewPresenter PRESENTER = new ResultViewPresenter();

    public String showSimulationResult(SimulationRequest request) {
        final SimulationResponse response = INTERACTOR.interact(request);
        return PRESENTER.present(response);
    }
}