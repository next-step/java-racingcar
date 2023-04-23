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
        String[] carsName = (inputView.inputCarName()).split(",");
        int tryCount = inputView.inputTryCount();

        List<Car> carList = new ArrayList<>();

        for (String carName : carsName) {
            carList.add(new Car(carName));
        }

        Cars cars = new Cars(carList);
        for (int i = 0; i < tryCount; i++) {
            cars.move();
        }

        List<Car> winners = cars.findWinners();
        ResultView.printWinners(winners);
    }
}