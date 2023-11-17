package racing;

import racing.controller.RacingCarApplication;
import racing.view.InputView;
import racing.view.OutputView;

public class Simulator {
    public static void main(String[] args) throws IllegalAccessException {
        RacingCarApplication application = new RacingCarApplication(new InputView(), new OutputView());
        application.run();
    }
}
