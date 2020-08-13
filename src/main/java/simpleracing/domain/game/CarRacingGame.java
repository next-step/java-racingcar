package simpleracing.domain.game;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

import simpleracing.domain.rule.CarRacingMoving;
import simpleracing.domain.rule.Moving;
import simpleracing.domain.tools.Car;
import simpleracing.domain.tools.CarRacingResult;
import simpleracing.domain.tools.Record;
import simpleracing.domain.tools.Records;
import simpleracing.domain.tools.Referee;
import simpleracing.view.input.CarRacingInitValue;

public class CarRacingGame implements CarGame {

	private List<Car> cars;
	private Moving moving = new CarRacingMoving();
	private Referee<Car> referee;

	public CarRacingGame(CarRacingInitValue initValue, Referee<Car> referee) {
		this.cars = IntStream.range(0, initValue.getNumberOfCars())
							 .mapToObj(carNumber -> new Car(initValue.getNames()
																	 .get(carNumber)
																	 .trim()))
							 .collect(toList());
		this.referee = referee;
	}

	@Override
	public CarRacingResult play(int numberOfAttempts) {
		List<Records> allRecords = IntStream.range(0, numberOfAttempts)
											.mapToObj(i -> new Records(startGame()))
											.collect(toList());
		List<Car> winners = referee.judge(cars);

		return new CarRacingResult(allRecords, winners);
	}

	private List<Record> startGame() {
		return cars.stream()
				   .map(car -> car.play(moving))
				   .collect(toList());
	}

}
