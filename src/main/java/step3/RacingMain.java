package step3;

import step3.controller.RacingController;
import step3.domain.RacingGame;
import step3.view.RacingInput;
import step3.view.RacingOutput;

public class RacingMain {
    private static final String INPUT_TIMES = "시도할 회수는 몇 회 인가요";
    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static void main(String[] args) {

        RacingController racingController = new RacingController();

        String[] carNames = racingController.inputForStringController(INPUT_CARS);
        int gameCoin = racingController.inputForIntController(INPUT_TIMES);

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < gameCoin; i++) {
            racingController.outputCars(racingGame.moveCars());
        }

        racingController.outputWinners(racingGame.findWinner());
    }
}

