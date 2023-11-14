package step4;

import java.util.List;

public class CarRacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.initInput();

        Car car = new Car(inputView.getCarNames());
        List<Car> carList = car.generateCars();

        ResultView resultView = new ResultView();
        resultView.makeResultView(carList);

        Winner winner = new Winner();
        winner.getWinners(carList);

        resultView.printWinners();

    }
}
