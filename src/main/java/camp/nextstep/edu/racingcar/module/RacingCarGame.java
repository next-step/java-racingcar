package camp.nextstep.edu.racingcar.module;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	public List<Car> generateCars(int input) {
		return IntStream.range(0, input)
			.mapToObj((int value) -> new Car())
			.collect(Collectors.toList());
	}

	public List<String> getCarStepString(List<Car> cars) {
		return cars.stream()
			.map(Car::getStepString)
			.collect(Collectors.toList());
	}
}
