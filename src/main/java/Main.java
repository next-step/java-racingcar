
import domain.Cars;
import service.CarRace;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarInfo();

        CarRace carRace = new CarRace();
        Cars cars = new Cars(carNames);

        ResultView resultView = new ResultView();
        resultView.printCarLocation(cars, carRace, inputView.getAttempts());
    }
}
