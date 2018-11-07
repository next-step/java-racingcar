package racingcar.view;

import racingcar.RacingGame;

public class RacingConsole {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        String carNames = inputView.getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int playTime = inputView.getInputNumber("시도할 회수는 몇회인가요?");

        racingGame.readyCars(carNames);
        racingGame.playRacingGame(playTime);
        racingGame.showWinner();
    }
}
