package camp.nextstep.edu.racingcar.module;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.racingcar.entity.Car;

public class RacingCarGame {

	private final RandomGenerator generator;

	private RacingCarGame() {
		this.generator = RandomGenerator.getInstance();
	}

	private static class LazyHolder {
		static final RacingCarGame INSTANCE = new RacingCarGame();
	}

	public static RacingCarGame getInstance() {
		return LazyHolder.INSTANCE;
	}

	public List<Car> moveCars(List<Car> cars) {
		return cars.stream()
			.peek(car -> {
				int randomNumber = generator.generateRandomNumber();
				car.move(randomNumber);
			})
			.collect(Collectors.toList());
	}

	public List<Car> generateCars(List<String> carNames) {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<String> getCarStepString(List<Car> cars) {
		return cars.stream()
			.map(Car::getStepStringWithName)
			.collect(Collectors.toList());
	}

	private int getWinnerStep(List<Car> cars) {
		return cars.stream()
			.map(Car::getStep)
			.max(Comparator.comparingInt(a -> a))
			.orElse(0);
	}

	public String getWinnerNames(List<Car> cars) {
		int winnerStep = getWinnerStep(cars);
		return cars.stream()
			.filter(car -> car.getStep() == winnerStep)
			.map(Car::getCarName)
			.collect(Collectors.joining(", "));
	}
}
