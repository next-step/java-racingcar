package racingcar.racing;

import racingcar.racing.view.InputView;

public class RacingGamePlayer {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int carCount = InputView.getUserInput("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.getUserInput("시도할 회수는 몇 회 인가요?");

        RacingCarGame racingCarGame = new RacingCarGame(carCount);
        racingCarGame.process(tryCount);

    }
}
