package step5.client;

import step5.client.view.output.Printer;
import step5.worker.interfaces.controller.RacingGameController;
import step5.worker.application.SimulationRequest;
import step5.client.view.input.InputView;

public class RacingGameClient {
    private static final RacingGameController controller = new RacingGameController();

    public static void main(String[] args) {
        final SimulationRequest request = InputView.receiveInputs();
        final String result = controller.showSimulationResult(request);
        Printer.print(result);
    }
}
