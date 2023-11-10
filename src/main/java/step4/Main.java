package step4;

import step4.view.InputView;
import step4.view.ResultView;

public class Main {
    public static void main(String[] args) {
        RacingApplication application = new RacingApplication(new InputView(), new ResultView());
        application.run();
    }
}
