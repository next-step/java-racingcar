package carracing;

import carracing.view.InputView;
import carracing.view.ResultView;

public class GameApplication {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new InputView(), new ResultView());
        carRacing.run();
    }
}
