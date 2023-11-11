package carracing.domain.car;

import carracing.domain.game.MovingStrategy;
import carracing.domain.game.WinnerStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다");
		}

		this.cars = cars;
	}

	public Winners winners(WinnerStrategy winnerStrategy) {
		return winnerStrategy.winners(this);
	}

	public void race(MovingStrategy movingStrategy, int tryingTimes) {
		for (int i = 0; i < tryingTimes; i++) {
			this.race(movingStrategy);
		}
	}

	public void race(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.move(movingStrategy);
		}
	}

	public int maxMovingDistance() {
		return this.cars.stream()
				.map(Car::movingDistance)
				.max(Comparator.comparingInt(movingDistance -> movingDistance))
				.orElseThrow(IllegalArgumentException::new);
	}

	public Cars winnersWithMaxMovingDistance(int maxMovingDistance) {
		List<Car> cars = this.cars.stream()
				.filter(car -> car.sameDistance(maxMovingDistance))
				.collect(Collectors.toList());

		return new Cars(cars);
	}

	public void printMovingResult() {
		for (Car car : cars) {
			String result = "-".repeat(Math.max(0, car.movingDistance()));
			System.out.println(car.name() + " : " + result);
		}
	}

	public void printWinners() {
		StringBuilder sb = new StringBuilder();
		for (Car winner : cars) {
			sb.append(winner.name()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append("가 최종 우승했습니다.");
		System.out.println(sb);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cars inputCars = (Cars) o;
		return Objects.equals(cars, inputCars.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
