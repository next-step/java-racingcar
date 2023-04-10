package study.step3;

public class RacingCarGame {

    static public void main(String[] args) {

        InputView inputView = new InputView();
        inputView.startMsg();

        RacingGame racingGame = new RacingGame();
        racingGame.readyGame(inputView.getCarCount());
        racingGame.startGame(inputView.getTryCount());

    }
}
