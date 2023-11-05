package ch3;

public class CarRacing {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public ResultView getResultView() {
        return resultView;
    }

    public void start(int carCount, int executeCount) {
    }

}
