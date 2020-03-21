package study.racingcar;

public class MainApplication {
    public static void main(String[] args) {
        RacingGameVo racingGameData = InputView.getUserInput();
        ResultView resultView = new ResultView(racingGameData);
        resultView.printResult();
    }
}
