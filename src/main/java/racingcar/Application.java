package racingcar;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.askCarCount());
        ResultView resultView = new ResultView(inputView.askTryCount(), cars);
        resultView.printResult();
    }
}
