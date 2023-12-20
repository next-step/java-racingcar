package racingcar.model.dto;

import racingcar.model.Cars;
import racingcar.model.Distance;

public class WinnerDTO {
	private final Cars cars;

	public Cars cars() {
		return cars;
	}

	private Distance maxDistance;

	public Distance maxDistance() {
		return maxDistance;
	}

	public void createMaxDistance(Distance maxDistance) {
		this.maxDistance = maxDistance;
	}

	private final int carNum;

	public int carNum() {
		return carNum;
	}

	public WinnerDTO(Cars cars, Distance maxDistance, int carNum) {
		this.cars = cars;
		this.maxDistance = maxDistance;
		this.carNum = carNum;
	}
}
