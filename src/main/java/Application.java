import controller.CarRacingController;
import view.InputView;
import view.ResultView;

public class Application {

        public static void main(String[] args)  {
            CarRacingController controller = new CarRacingController(new InputView(), new ResultView());
            controller.startCarRacing();
        }
}