import controller.RacingCarController;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarGame {

    public static void main(String[] args) {
        new RacingCarController(new InputView(), new RandomNumberGenerator(), new OutputView()).start();
    }
}
