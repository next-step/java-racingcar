package racingcar;

public class View {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public String readCarNames() {
        outputView.printCarNames();
        return inputView.read();
    }

    public String readCount() {
        outputView.printCount();
        return inputView.read();
    }

    public void printResult(String racingGameResult) {
        outputView.printPlayResultTitle();
        outputView.print(racingGameResult);
    }
}
