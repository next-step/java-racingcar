package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import simpleracing.input.CarRacingInitValue;

public class CarRacingGame {

	private static final int RANDOM_MAX_VALUE = 10;
	private Random randomValueGenerator;
	private CarRacingInitValue initValue;

	public CarRacingGame(CarRacingInitValue initValue) {
		this.initValue = initValue;
		this.randomValueGenerator = new Random();
	}

	public List<Car> play() {
		return IntStream.range(0, initValue.getCarCount())
						.mapToObj(carNumber -> new Car(carNumber,
													   IntStream.range(0, initValue.getTryCount())
																.mapToObj(tryCount -> randomValueGenerator.nextInt(RANDOM_MAX_VALUE))
																.collect(toList())))
						.collect(toList());
	}
}
