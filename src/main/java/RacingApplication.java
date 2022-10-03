import controller.RacingGameController;
import view.InputView;
import view.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        new RacingGameController(new InputView(), new ResultView()).run();
    }
}
