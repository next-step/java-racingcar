package racing;

import java.util.List;

import static racing.ResultView.printWinners;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        String[] carsName = (inputView.inputCarName()).split(",");
        int tryCount = inputView.inputTryCount();

        Cars cars = new Cars(carsName);
        List<Car> carList = cars.getCars();

        for (int i = 0; i < tryCount; i++) {
            cars.moveCarList(carList);
        }

        List<Car> winners = cars.findWinners(carList);
        printWinners(winners);


    }
}
