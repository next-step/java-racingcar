package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.strategy.MovableStrategy;

public class RacingCars {
	private List<RacingCar> racingCars = new ArrayList<>();

	public RacingCars(String[] carNames, MovableStrategy movableStrategy) {
		for (int i = 0; i < carNames.length; i++) {
			racingCars.add(new RacingCar(carNames[i], movableStrategy));
		}
	}

	public List<RacingCar> getCars() {
		return racingCars;
	}

	public int getRacingCarsNumber() {
		return racingCars.size();
	}

	public void forwardCars() {
		racingCars.stream()
			.forEach(RacingCar::forward);
	}

	private int getRacingCarsMaxPosition() {
		return racingCars.stream()
			.mapToInt(racingCar -> racingCar.getPosition())
			.max()
			.orElseThrow(NoSuchElementException::new);
	}

	public List<String> getWinners() {
		return racingCars.stream()
			.filter(car -> car.getPosition() == getRacingCarsMaxPosition())
			.map(RacingCar::getCarName)
			.collect(Collectors.toList());
	}
}
