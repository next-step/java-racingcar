package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class GameWinners {
	List<Car> carList;

	public GameWinners(GameStatus gameStatus) {
		this.carList = gameStatus.getStatus();
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		return carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(car -> car.getCarName())
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

		Car car = carList.stream()
			.max(comparatorByPosition)
			.orElseThrow(NoSuchElementException::new);

		return car.getPosition();
	}
}
