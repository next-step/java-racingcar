import java.util.List;

import Service.CarRace;
import Service.InputView;
import Service.ResultView;
import domain.Car;
import repository.CarHistory;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarInfo();

        CarRace carRace = new CarRace();
        List<Car> carList = carRace.createInitCarList(inputView.getCarNames());

        CarHistory carHistory = new CarHistory();
        carHistory.saveCarHistory(carList);

        ResultView resultView = new ResultView();
        resultView.printCarLocation(carRace, carHistory, inputView.getAttempts());
    }
}
