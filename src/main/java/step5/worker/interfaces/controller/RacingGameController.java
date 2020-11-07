package step5.worker.interfaces.controller;

import step5.worker.interfaces.presenter.ResultViewPresenter;
import step5.worker.application.SimulationResponse;
import step5.worker.application.SimulationResponseInterator;
import step5.worker.application.SimulationRequest;

public class RacingGameController {
    private static final SimulationResponseInterator INTERATOR = new SimulationResponseInterator();
    private static final ResultViewPresenter PRESENTER = new ResultViewPresenter();

    public String showSimulationResult(SimulationRequest request) {
        final SimulationResponse response = INTERATOR.interact(request);
        return PRESENTER.present(response);
    }
}