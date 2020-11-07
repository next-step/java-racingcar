package step3.client;

import step3.client.view.output.Printer;
import step3.worker.interfaces.controller.RacingGameController;
import step3.worker.application.SimulationRequest;
import step3.client.view.input.InputView;

public class RacingGameClient {
    private static final RacingGameController controller = new RacingGameController();

    public static void main(String[] args) {
        final SimulationRequest request = InputView.receiveInputs();
        final String result = controller.showSimulationResult(request);
        Printer.print(result);
    }
}
