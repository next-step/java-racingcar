package step3;

import java.util.List;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarController carController = new CarController();

        int numberOfCars = inputView.numberOfCars();
        int tryCounts = inputView.tryCount();

        List<CarList> carListResult = carController.gameStart(numberOfCars, tryCounts);

        outputView.resultMention();
        outputView.displayCarListResult(carListResult);
    }
}
