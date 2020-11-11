package racingcar;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController carController = new CarController();

        String[] carNames = inputView.carNames();
        int tryCounts = inputView.tryCount();

        outputView.resultMention();

        CarList carList = carController.initCarList(carNames);

        int round = 0;
        while(!carController.isFinish(tryCounts, round)) {
            outputView.displayCarList(carController.nextRound(carList));
            round++;
        }

        outputView.displayWinners(carController.getWinner(carList));
    }
}
