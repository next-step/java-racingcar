import java.util.List;

import Service.CarRace;
import Service.InputView;
import Service.ResultView;
import domain.Car;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarInfo();

        CarRace carRace = new CarRace();
        carRace.createInitCarList(inputView.getCarNames());
        List<Car> carList = carRace.updateCurrentLocation(carRace.getRacingCars());

        ResultView resultView = new ResultView();
        resultView.printCarLocation(carRace, carList, inputView.getAttempts());
    }
}
