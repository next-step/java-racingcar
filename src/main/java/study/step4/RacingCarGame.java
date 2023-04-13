package study.step4;

public class RacingCarGame {

    static public void main(String[] args) {

        InputView inputView = new InputView();
        inputView.startMsg();

        RacingGame racingGame = new RacingGame();
        racingGame.readyGame(inputView.getCarList());
        racingGame.startGame(inputView.getTryCount());
        racingGame.getWinner();
    }
}
