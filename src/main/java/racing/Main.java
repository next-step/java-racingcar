package racing;


import racing.domain.Car;
import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        InputView inputView = InputView.getInstance();

        //사용자 입력
        String inputCarName = inputView.inputCarName();
        String[] carsName = inputView.splitCarsName(inputCarName);
        int tryCount = inputView.inputTryCount();

        Cars cars = new Cars();
        List<Car> carList = cars.getCars(carsName);

        Cars movingCars = new Cars(carList);

        for (int i = 0; i < tryCount; i++) {
            movingCars.racingCars();
        }

        List<Car> winners = movingCars.findWinners();
        ResultView.printWinners(winners);
    }
}