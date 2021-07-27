package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.RacingCarUtil;

public class RacingCars {
	private List<RacingCar> racingCars = new ArrayList<>();

	public List<RacingCar> getCars() {
		return racingCars;
	}

	public RacingCars(int carNum) {
		for (int i = 0 ; i < carNum ; i++) {
			racingCars.add(new RacingCar());
		}
	}

	public void forwardCars() {
		racingCars.stream()
			.filter(racingCar -> racingCar.isMovable(RacingCarUtil.generateForwardValue()))
			.forEach(racingCar -> {
				racingCar.forward();
			});
	}
}
