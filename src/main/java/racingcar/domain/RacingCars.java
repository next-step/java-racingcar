package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.RoundResult;

public class RacingCars {
	private final List<Car> cars;

	public RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	public static RacingCars of(CarNames carNames) {
		return new RacingCars(carNames.values()
			.stream()
			.map(Car::new)
			.collect(Collectors.toList()));
	}

	public RoundResult play(EngineStrategy engineStrategy) {
		cars.forEach(
			car -> car.run(engineStrategy.generate()));

		return new RoundResult(cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList()));
	}

	public boolean isSameSize(int size) {
		return cars.size() == size;
	}

	public Winners rankWinners() {
		return new Winners(cars);
	}
}


// 달리는 차
// 랭킹결과(우승 차)