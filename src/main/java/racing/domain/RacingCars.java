package racing.domain;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCars {
	private List<Car> racingCars;

	public RacingCars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void startRacing(int count) {
		IntStream.range(0, count).
			forEach(i -> moveCars());

	}

	private void moveCars() {
		IntStream.range(0, racingCars.size())
			.forEach(i -> racingCars.get(i).move());
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}
}
