package step3;

import step3.controller.InputController;
import step3.controller.ResultController;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputController.enterInput();
        RacingGame racingGame = new RacingGame(spec.getCarCount());
        ResultController resultController = new ResultController();
        IntStream.range(0, spec.getMoveCount()).forEach(i -> {
            racingGame.playStep();
            resultController.printRacingLog(racingGame.getStepResult());
        });
    }
}
