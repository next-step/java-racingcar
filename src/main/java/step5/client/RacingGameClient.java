package step5.client;

import step5.client.view.output.Printer;
import step5.client.worker.interfaces.controller.RacingGameController;
import step5.client.worker.application.SimulationRequest;
import step5.client.view.input.RacingGameInputView;

public class RacingGameClient {
    private static final RacingGameController controller = new RacingGameController();

    public static void main(String[] args) {
        final SimulationRequest request = RacingGameInputView.receiveInputs();
        final String result = controller.showSimulationResult(request);
        Printer.print(result);
    }
}
