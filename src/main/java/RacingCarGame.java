import controller.RacingCarController;
import model.RandomNumberGenerator;
import view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {
        new RacingCarController(new InputView(), new RandomNumberGenerator()).start();
    }
}
