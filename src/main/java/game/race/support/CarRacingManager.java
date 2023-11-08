package game.race.support;

import java.util.List;

import game.race.Car;
import game.race.model.InputView;
import game.race.model.ResultView;

public class CarRacingManager {

    public static void start(InputView inputView) {
        ResultView resultView = new ResultView();
        List<Car> cars = Car.getCars(inputView.getVehicleCnt());

        resultView.showPrompt();
        for (int trial = 0; trial < inputView.getTryCnt(); trial++) {
            for (Car car : cars) {
                car.move();
            }

            resultView.showCars(cars);
            resultView.markEnd();
        }
    }
}
