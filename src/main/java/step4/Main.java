package step4;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGameInputData racingGameInputData = inputView.init();
        RacingGame racingGame = new RacingGame(new ResultView(), racingGameInputData);
        racingGame.race(new RacingDice());
    }
}
