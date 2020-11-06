package step3;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        int car = InputView.inputCarCount();
        int move = InputView.inputMoveCount();

        InputView.close();

        racingGame.run(car, move);
    }
}
