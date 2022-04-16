import controller.CarRacingController;
import util.RandomNumberMove;
import view.InputView;
import view.ResultView;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController(
                InputView.getInstance(),
                ResultView.getInstance(),
                RandomNumberMove.getInstance()
        );
        carRacingController.startRacing();
    }
}
