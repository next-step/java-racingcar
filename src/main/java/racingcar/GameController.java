package racingcar;

public class GameController {
    private InputView inputView;
    private ResultView resultView;
    private CarCollection cars;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int carNumber = inputView.readCarNumber();
        int trialNumber = inputView.readTrialNumber();
        this.cars = new CarCollection(carNumber);

        this.tryMoves(trialNumber);
    }

    private void tryMoves(int trialNumber) {
        for (int i = 0; i< trialNumber; i++) {
            cars.tryMove();
            resultView.printResult(cars.getPositionList());
        }
    }
}
