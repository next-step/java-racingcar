package racing.client;

import racing.controller.RacingController;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingClient {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputView(), new ResultView());
        racingController.racingStart();
    }
}
