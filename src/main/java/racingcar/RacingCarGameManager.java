package racingcar;

import static racingcar.RacingCarGame.createRacingCars;

public class RacingCarGameManager {
    public static void main(String[] args) {
        InputView.displayMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = InputView.getStringInput();

        InputView.displayMessage("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = InputView.getUserInput();

        RacingCarGame game = new RacingCarGame(carNames, numberOfRounds);
        game.runGame();

        ResultView.displayWinner(game.getWinners());
    }
}
