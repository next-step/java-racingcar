import controller.CarRacingController;
import view.InputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarRacingController carRacingController = new CarRacingController(inputView);
        carRacingController.runRacingCar();
    }
}
