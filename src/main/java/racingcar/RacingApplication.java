package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int numberOfParticipants = inputView.receiveNumberOfParticipants();
        int numberOfOperations = inputView.receiveNumberOfOperations();

        RacingGame racingGame = new RacingGame(numberOfParticipants);
        outputView.printStartMessage();
        for (int i = 0; i < numberOfOperations; i++) {
            racing(racingGame, outputView);
        }

    }

    private static void racing(RacingGame racingGame, OutputView outputView) {
        racingGame.tryOneRace();
        outputView.printResult(racingGame.getResults());
    }
}
