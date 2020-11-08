package racingcar;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController carController = new CarController();

        int numberOfCars = inputView.numberOfCars();
        int tryCounts = inputView.tryCount();

        outputView.resultMention();

        CarList carList = carController.initCarList(numberOfCars);
        for(int round = 0; round < tryCounts; round++) {
            outputView.displayCarList(carController.nextRound(carList));
        }
    }
}
