package racing.controller;

import racing.model.Car;
import racing.model.Cars;
import racing.view.ResultView;

import java.util.List;

public class RaceController {

    public void startRacing(int carNum, int attempts) {
        Cars cars = new Cars(carNum);

        ResultView.printRacingResult(moving(cars.getCars()));
    }

    private List<Car> moving(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

}
