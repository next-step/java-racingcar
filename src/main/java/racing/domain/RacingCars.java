package racing.domain;

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
		return IntStream.range(0, racingCars.size())
			.filter(i -> isWinner(racingCars.get(i)))
			.mapToObj(i -> racingCars.get(i))
			.collect(Collectors.toList());
	}

	private boolean isWinner(Car car) {
		return car.isWinner(getAnyWinner());
	}

	private Car getAnyWinner() {
		return racingCars.stream()
			.max(Car.comparatorByLocation())
			.orElseThrow(() -> {
				throw new NoSuchWinnerException(ErrorMessage.NO_SUCH_WINNER);
			});
	}
}
