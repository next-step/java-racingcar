package racingcar.racing;

import racingcar.racing.view.InputView;

public class Player {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int carCount = InputView.getUserInput("자동차 대수는 몇 대 인가요?");
        int loopCount = InputView.getUserInput("시도할 회수는 몇 회 인가요?");

        Game game = new Game(carCount);
        for (int i = 0; i < loopCount; i++)
            game.start();
    }
}
