package step4;

import java.util.List;

public class CarRacingMain{
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.initInput();

        Car car = new Car();
        List<Car> carList = car.generateCars(inputView.getCarNames());

        ResultView resultView = new ResultView();
        resultView.makeResultView(carList);

        Winners winners = new Winners();
        winners.getWinners(carList);

        resultView.printWinners(winners.getWinnerNames());

    }
}

