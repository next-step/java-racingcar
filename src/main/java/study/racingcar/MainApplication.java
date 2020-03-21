package study.racingcar;

public class MainApplication {
    public static void main(String[] args) {
        RacingGameVo racingGameVo = InputView.getUserInput();
        ResultView resultView = new ResultView(racingGameVo);
        resultView.printResult();
    }
}
