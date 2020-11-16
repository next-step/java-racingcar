package step5;

import step5.controller.RacingCarController;

import static step5.view.RacingCarUi.*;

public class RacingCarMain {

    public static void main(String[] args) {

        String[] carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        close();
        RacingCarController racingCarController = RacingCarController.of(carNames, numberOfMove);

        while (!racingCarController.isFinish()) {
            resultPrint(racingCarController.gameProgress());
        }

        finalWinner(racingCarController.getCars());
    }
}
