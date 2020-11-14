package racingcar;

import view.InputView;
import view.ResultView;

public class RacingCarGameManager {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int numberOfRounds = InputView.getRounds("시도할 회수는 몇 회 인가요?");

        RacingCarGame game = new RacingCarGame(carNames, numberOfRounds);
        game.runGame();

        ResultView.displayWinner(game.getWinners());
    }
}
