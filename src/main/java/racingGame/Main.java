package racingGame;

public class Main {

    public static void main(String[] args) {
        int carSize = InputView.inputCarSize();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(carSize, repeatCount);

        ResultView.printGameStart();
        for (int i = 0; i < repeatCount; i++) {
            game.runOnce();
            ResultView.printResult(game.getCarsStatus());
        }
    }
}
