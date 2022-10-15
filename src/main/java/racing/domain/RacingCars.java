package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racing.exception.ErrorMessage;
import racing.exception.NoSuchWinnerException;

public class RacingCars {
	private List<Car> racingCars;

	public RacingCars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void moveCars() {
		IntStream.range(0, racingCars.size())
			.forEach(i -> racingCars.get(i).move());
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}

	public List<Car> getWinnersOfRacing() {
		final int maxLocation;
		try {
			maxLocation = getMaxLocation();
		} catch (NoSuchWinnerException exception) {
			return Collections.emptyList();
		}

		final List<Car> winners = IntStream.range(0, racingCars.size())
			.filter(i -> racingCars.get(i).getLocation() == maxLocation)
			.mapToObj(i -> racingCars.get(i))
			.collect(Collectors.toList());

		return winners;
	}

	private int getMaxLocation() {
		Car anyWinner = racingCars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> {
				throw new NoSuchWinnerException(ErrorMessage.NO_SUCH_WINNER);
			});

		return anyWinner.getLocation();
	}

}
