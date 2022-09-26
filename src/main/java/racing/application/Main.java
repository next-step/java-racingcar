package racing.application;

import racing.application.controller.RacingController;
import racing.application.view.InputView;

public class Main {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(
            new InputView()
        );
        racingController.play();


    }
}
