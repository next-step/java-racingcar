import controller.CarRacingController;
import view.InputView;
import view.ResultView;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarRacingController carRacingController = new CarRacingController(inputView, resultView);
        carRacingController.runRacingCar();
    }
}
