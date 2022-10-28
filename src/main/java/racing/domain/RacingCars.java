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

	public RacingCars(List<String> carNames, RandomNum randomNum) {
		this.racingCars = carNames.stream()
			.map(carName -> new Car(carName, randomNum))
			.collect(Collectors.toList());
	}

	public void moveCars() {
		IntStream.range(0, racingCars.size())
			.forEach(i -> racingCars.get(i).move());
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}

	public List<Car> getWinnersOfRacing() {
		Car anyWinner = getAnyWinner();

		return IntStream.range(0, racingCars.size())
			.filter(i -> racingCars.get(i).isWinner(anyWinner))
			.mapToObj(i -> racingCars.get(i))
			.collect(Collectors.toList());
	}

	private Car getAnyWinner() {
		return racingCars.stream()
			.reduce((car, nextCar) -> car.isWinner(nextCar) ? car : nextCar)
			.orElseThrow(() -> {
				throw new NoSuchWinnerException(ErrorMessage.NO_SUCH_WINNER);
			});
	}
}
