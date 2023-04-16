package step3;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.run();
        racingGame.race(new RacingDice(), new RacingResultView());
    }
}
