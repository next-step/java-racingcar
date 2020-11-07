package step3;

import step3.application.ShowSimulationResponseInterator;
import step3.application.SimulationRequest;
import step3.application.SimulationResponse;
import step3.view.output.presenter.ResultViewPresenter;
import step3.view.input.InputView;
import step3.view.output.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        final SimulationRequest request = receiveRequest();
        final SimulationResponse response = showSimulationResponse(request);
        print(response);
    }

    private static SimulationRequest receiveRequest() {
        return InputView.receiveSimulationCondition();
    }

    private static SimulationResponse showSimulationResponse(final SimulationRequest condition) {
        final ShowSimulationResponseInterator interator = new ShowSimulationResponseInterator(condition);
        return interator.interact();
    }

    private static void print(final SimulationResponse response) {
        final ResultViewPresenter resultViewPresenter = new ResultViewPresenter(response);
        ResultView.print(resultViewPresenter);
    }
}
