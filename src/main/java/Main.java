import Service.CarRace;
import Service.InputView;
import Service.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarInfo();

        CarRace carRace = new CarRace();
        carRace.createInitCarList(inputView.getCarNames());

        ResultView resultView = new ResultView();
        resultView.printCarLocation(carRace.getRacingCars(), inputView.getAttempts());
    }
}
