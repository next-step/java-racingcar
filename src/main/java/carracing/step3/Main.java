package carracing.step3;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.enterCarCount();
        int tryCount = inputView.enterTryCount();

        Cars cars = new Cars(carCount);

        ResultView resultView = new ResultView();
        resultView.printResults(tryCount, cars);
    }
}
