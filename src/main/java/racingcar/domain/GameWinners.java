package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class GameWinners {
	List<Car> carList;

	public GameWinners(GameStatus gameStatus) {
		this.carList = gameStatus.getStatus();
	}

	public List<String> getWinners() {
		List<String> winnersName = new ArrayList<>();
		int maxPosition = getMaxPosition();
		carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.forEach(car -> winnersName.add(car.getCarName()));
		return winnersName;
	}

	private int getMaxPosition() {
		Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

		Car car = carList.stream()
			.max(comparatorByPosition)
			.orElseThrow(NoSuchElementException::new);

		return car.getPosition();
	}
}
