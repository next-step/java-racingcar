package racingGame;

import racingGame.view.InputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        RacingGame racingGame = new RacingGame();
        racingGame.setParticipateCount(inputView.getParticipateCount());
        racingGame.setGameCount(inputView.getGameCount());

        String result = racingGame.start();

        System.out.println(result);
    }
}
