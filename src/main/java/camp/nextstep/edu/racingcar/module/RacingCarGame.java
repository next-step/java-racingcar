package camp.nextstep.edu.racingcar.module;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.racingcar.entity.Car;
import camp.nextstep.edu.racingcar.entity.Name;

public class RacingCarGame {

	private RacingCarGame() {
	}

	private static class LazyHolder {
		static final RacingCarGame INSTANCE = new RacingCarGame();
	}

	public static RacingCarGame getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void moveCars(List<Car> cars) {
		cars.forEach(car -> car.move(RandomMovingStrategy.getInstance()));
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
			.filter(car -> car.isWinner(winnerStep))
			.map(Car::getName)
			.map(Name::toString)
			.collect(Collectors.joining(", "));
	}
}
