package step3.worker.interfaces.controller;

import step3.worker.interfaces.presenter.ResultViewPresenter;
import step3.worker.application.SimulationResponse;
import step3.worker.application.SimulationResponseInterator;
import step3.worker.application.SimulationRequest;

public class RacingGameController {
    private static final SimulationResponseInterator INTERATOR = new SimulationResponseInterator();

    public String showSimulationResult(SimulationRequest request) {
        final SimulationResponse response = INTERATOR.interact(request);
        final ResultViewPresenter resultViewPresenter = new ResultViewPresenter(response);
        return resultViewPresenter.present();
    }
}