package study.racingcar;

public class MainApplication {
    public static void main(String[] args) {
        RacingGameData racingGameData = InputView.getUserInput();
        ResultView resultView = new ResultView(racingGameData);
        resultView.printResult();
    }
}
