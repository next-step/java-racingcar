package racing.model;

import racing.model.service.CarConditional;

public class RacingCar {

	// 자동차 경주 시작 위치 0
	private static final int RACING_START_LOCATION = 0;

	// 자동차 주행 거리
	private final Location location;

	// 자동차 이름
	private final CarName carName;

	public RacingCar(CarName carName) {

		this(carName, RACING_START_LOCATION);
	}

	public RacingCar(CarName carName, int location) {

		this.carName = carName;
		this.location = new Location(location);
	}

	public void move(CarConditional carConditional) {

		if (carConditional.isMove()) {

			this.location.move();
		}
	}

	/**
	 * 자동차 주행 거리 리턴
	 * @return : 자동차 주행 거리 정수 리턴
	 */
	public int getDistance() {
		return this.location.getDistance();
	}

	public String getCarName() {
		return this.carName.getName();
	}
}
