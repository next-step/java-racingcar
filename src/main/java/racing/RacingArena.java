package racing;

import racing.domain.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingArena {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        int vehicleCount = InputView.getVehicleCount();
        int maxCheckPoint = InputView.getMaxCheckPoint();
        List<Car> cars = new CarRacing(vehicleCount,maxCheckPoint).getRacingCars();
        resultView.racingResults(cars,maxCheckPoint);
    }
}
