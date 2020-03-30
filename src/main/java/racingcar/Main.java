package racingcar;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = InputView.start();
        RacingGameResult racingGameResult = racingGame.run();
        OutputView.print(racingGameResult);
    }
}
