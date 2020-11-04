package step3;

import step3.controller.InputController;
import step3.controller.ResultController;
import step3.strategy.RandomStrategy;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputController.enterInput();
        RacingGame racingGame = new RacingGame(spec.getCarCount(), new RandomStrategy());
        ResultController resultController = new ResultController();
        IntStream.range(0, spec.getMoveCount()).forEach(i -> {
            racingGame.playStep();
            RacingCarList racingCarList = racingGame.getRacingCarList();
            resultController.printRacingLog(racingCarList.getRacingStatus());
        });
    }
}
