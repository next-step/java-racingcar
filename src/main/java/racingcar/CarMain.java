package racingcar;

import racingcar.view.InputView;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        // 입력
        String carNames = inputView.getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int round = inputView.getInputNumber("시도할 횟수는 몇 회 인가요?");

        // 경주
        RacingGame racingGame = new RacingGame(carNames, round);
        racingGame.race();
    }
}
