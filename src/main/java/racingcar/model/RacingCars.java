package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.exception.OverFiveCarNameException;
import racingcar.strategy.MovableStrategy;

public class RacingCars {
	private List<RacingCar> racingCars = new ArrayList<>();

	public List<RacingCar> getCars() {
		return racingCars;
	}

	public RacingCars(int carNum, MovableStrategy movableStrategy) {
		for (int i = 0; i < carNum; i++) {
			racingCars.add(new RacingCar(movableStrategy));
		}
	}

	public RacingCars(String[] carNames, MovableStrategy movableStrategy) throws OverFiveCarNameException {
		for (int i = 0; i < carNames.length; i++) {
			racingCars.add(new RacingCar(carNames[i], movableStrategy));
		}
	}

	public void forwardCars() {
		racingCars.stream()
			.forEach(racingCar -> {
				racingCar.forward();
			});
	}

	public List<String> getWinners() {
		Stream<RacingCar> stream = racingCars.stream();
		int maxPosition = stream.map(RacingCar::getPosition).mapToInt(carPosition -> carPosition).max().orElseThrow(NoSuchElementException::new);

		stream = racingCars.stream();
		List<String> winners = stream.filter(car -> car.getPosition() == maxPosition).map(RacingCar::getCarName).collect(Collectors.toList());

		return winners;
	}
}
