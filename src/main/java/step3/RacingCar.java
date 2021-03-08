package step3;

public class RacingCar {

    public RacingCar() {}

    void start() {
        InputView inputView = new InputView();
        int car = inputView.getInput()[0];
        int trial = inputView.getInput()[1];

        ResultView resultView = new ResultView();
        resultView.printResult(car, trial);
    }

}
