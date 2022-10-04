package carRacing.level3.controller;

import carRacing.level3.model.Car;
import carRacing.level3.model.Cars;
import carRacing.level3.model.strategy.MovingStrategy;
import carRacing.level3.view.input.InputView;
import carRacing.level3.view.output.OutPutView;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameController {

	private static final Integer DEFAULT_CAR_NUM = 0;
	InputView inputView = new InputView();
	OutPutView outPutView = new OutPutView();

	public void gameStart(MovingStrategy strategy) {

		int gameRound = inputView.askValueRound();
		int totalCarNum = inputView.askNumberCars();

		Cars cars = initiateCars(totalCarNum);

		for (int i = 0; i < gameRound; i++) {
			cars.moveCarLocation(strategy);
			output(cars, totalCarNum);
		}


	}

	public Cars initiateCars(int totalCarNum) {
		return new Cars(
			IntStream.range(DEFAULT_CAR_NUM, totalCarNum)
				.mapToObj(index -> new Car())
				.collect(Collectors.toList()));
	}

	public void output(Cars cars, int totalCarNum) {
		outPutView.showRace(cars, totalCarNum);
		outPutView.printSpace();
	}

}
