package racing.car;

import racing.car.controller.CarRacingController;
import racing.car.domain.CarRacing;
import racing.car.view.InputView;
import racing.car.view.ResultView;

public class CarRacingMain {

	public static void main(String[] args) {
		CarRacingController controller = new CarRacingController(new InputView(), new ResultView(), new CarRacing());
		controller.run();
	}
}
