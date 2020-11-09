package racingcar;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController carController = new CarController();

        String[] carNames = inputView.carNames().split(",");
        int tryCounts = inputView.tryCount();

        outputView.resultMention();

        CarList carList = carController.initCarList(carNames);
        for(int round = 0; round < tryCounts; round++) {
            outputView.displayCarList(carController.nextRound(carList));
        }

        outputView.displayWinners(carController.getWinner(carList));
    }
}
