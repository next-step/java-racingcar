package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.strategy.MovableStrategy;

public class RacingCars {
	private List<RacingCar> racingCars = new ArrayList<>();

	public List<RacingCar> getCars() {
		return racingCars;
	}

	public RacingCars(int carNum, MovableStrategy movableStrategy) {
		for (int i = 0 ; i < carNum ; i++) {
			racingCars.add(new RacingCar(movableStrategy));
		}
	}

	public void forwardCars() {
		racingCars.stream()
			.forEach(racingCar -> {
				racingCar.forward();
			});
	}
}
