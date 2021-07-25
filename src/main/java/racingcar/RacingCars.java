package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	List<RacingCar> racingCars = new ArrayList<>();

	public List<RacingCar> getCars() {
		return racingCars;
	}

	public RacingCars(int carNum) {
		for (int i = 0 ; i < carNum ; i++) {
			racingCars.add(new RacingCar(RacingCar.INITIAL_POSITION));
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
