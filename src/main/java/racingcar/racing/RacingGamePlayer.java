package racingcar.racing;

import racingcar.racing.view.InputView;

import java.util.List;

public class RacingGamePlayer {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        List<String> carNames = InputView.getStringListInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", ",");
        int tryCount = InputView.getPositiveNumberInput("시도할 회수는 몇 회 인가요?");

        RacingCarGame racingCarGame = new RacingCarGame(carNames);
        racingCarGame.playAndWinners(tryCount);
    }
}
