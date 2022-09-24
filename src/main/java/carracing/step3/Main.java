package carracing.step3;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.enterCarCount();
        int tryCount = inputView.enterTryCount();

        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; ++i) {
            cars[i] = new Car();
        }

        ResultView resultView = new ResultView();
        resultView.printResults(carCount, tryCount, cars);
    }
}
