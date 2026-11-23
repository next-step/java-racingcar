package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;

public class RacingResult {

	private final List<CarResult> carResults = new ArrayList<>();


	public RacingResult(List<Car> cars) {
		for (Car car : cars) {
			carResults.add(new CarResult(car.getName(), car.getPosition()));
		}
	}

	public List<CarResult> getCarResults() {
		return carResults;
	}

	public List<String> findWinners() {
		List<String> winners = new ArrayList<>();
		int maxPosition = getMaxPosition();

		for (CarResult carResult : carResults) {
			addIfWinner(carResult, maxPosition, winners);
		}

		return winners;
	}

	private static void addIfWinner(CarResult carResult, int maxPosition, List<String> winners) {
		if (carResult.getPosition() == maxPosition) {
			winners.add(carResult.getName());
		}
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (CarResult carResult : carResults) {
			maxPosition = Math.max(carResult.getPosition(), maxPosition);
		}
		return maxPosition;
	}
}
