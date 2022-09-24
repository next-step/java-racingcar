package racing.application;

import racing.application.controller.RacingController;
import racing.application.service.RacingServiceImpl;
import racing.application.view.InputView;
import racing.application.view.View;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingController racingController = new RacingController(new RacingServiceImpl());

        String names = inputView.inputNames();
        int moveCount = inputView.moveCount();

        View view = racingController.racingGame(names, moveCount);

        view.print();
    }
}
