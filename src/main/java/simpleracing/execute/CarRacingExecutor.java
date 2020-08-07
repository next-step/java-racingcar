package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

import simpleracing.input.CarRacingInitValue;
import simpleracing.input.CarRacingInput;
import simpleracing.input.InputView;
import simpleracing.output.CarRacingOutput;


public class CarRacingExecutor {

	private InputView carRacingInput;
	private CarGame racingGame;
	private CarRacingReferee referee;
	private CarRacingOutput carRacingOutput;

	public CarRacingExecutor() {
		this.carRacingInput = new CarRacingInput();
		this.racingGame = new CarRacingGame();
		this.referee = new CarRacingReferee();
		this.carRacingOutput = new CarRacingOutput();
	}

	public void execute() {
		CarRacingInitValue initValue = carRacingInput.input();

		List<Car> cars = IntStream.range(0, initValue.getCarCount())
								  .mapToObj(carNumber -> new Car(carNumber,
																 initValue.getNames()
																		  .get(carNumber)
																		  .trim(),
																 this.racingGame)
										   )
								  .collect(toList());
		this.playGame(initValue, cars);
		this.referee(cars);
		carRacingOutput.render();

	}

	private void playGame(CarRacingInitValue initValue, List<Car> cars) {
		IntStream.range(0, initValue.getTryCount())
				 .forEach(round -> {
					 cars.stream()
						 .forEach(car -> car.play());
					 this.carRacingOutput.addSituation(cars);
				 });
	}

	private void referee(List<Car> cars) {
		referee.judgeRacingResult(cars);
		carRacingOutput.addWinner(referee.announceWinner());
	}
}
