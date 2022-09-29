package carRacing.level3.service;

import carRacing.level3.domain.Car;
import carRacing.level3.domain.Cars;
import carRacing.level3.service.strategy.MovingStrategy;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarService {

	private static final Integer DEFAULT_CAR_NUM = 0;

	public Cars prepare(int totalCarNum) {
		return new Cars(
			IntStream.range(DEFAULT_CAR_NUM, totalCarNum)
				.mapToObj(index -> new Car())
				.collect(Collectors.toList()));
	}

	public void moveCar(int gameRound, Cars cars, MovingStrategy strategy) {
		for (int i = 0; i < gameRound; i++) {
			cars.moveCarLocation(strategy);
		}
	}

}
