import controller.CarRacingController;
import view.InputView;
import view.ResultView;

import java.util.Random;

public class Application {

        public static void main(String[] args)  {
            CarRacingController controller = new CarRacingController(new InputView(), new ResultView(), new Random());
            controller.startCarRacing();
        }
}