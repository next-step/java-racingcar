package racingcar;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView);
        racingGame.startGame();
    }
}
