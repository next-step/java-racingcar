import domain.CarRace;
import util.CommonUtil;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askNumberOfCars();
        int cars = inputView.getInputNumber();

        inputView.askNumberOfTurns();
        int turns = inputView.getInputNumber();

        resultView.printRaceStart();

        StringBuilder[] carArray = CommonUtil.initializeArray(cars);
        startRace(carArray, cars, turns);
    }

    public static void startRace(StringBuilder[] carArray, int cars, int turns) {
        ResultView resultView = new ResultView();

        for (int i = 0; i < turns; i++) {
            goOrStay(carArray, cars);
            resultView.printEndOfTurn();
        }
    }

    public static void goOrStay(StringBuilder[] carArray, int cars) {
        CarRace carRace = new CarRace();
        ResultView resultView = new ResultView();

        for (int i = 0; i < cars; i++) {
            carArray[i] = carRace.getResult(carArray[i]);
            resultView.printResultOfTurn(carArray[i]);
        }
    }

}
