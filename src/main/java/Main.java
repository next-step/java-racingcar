
import domain.Cars;
import service.CarRace;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Cars cars =  inputView.inputCarInfo();
        int attempts = inputView.getAttempts();

        CarRace carRace = new CarRace();

        ResultView resultView = new ResultView();
        resultView.printCarLocation(cars, carRace, attempts);
    }
}
