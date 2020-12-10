package racing.model;

import racing.model.service.CarConditional;

public class RacingCar {

	// 자동차 경주 시작 위치 0
	private static final int RACING_START_LOCATION = 0;

	// 자동차 주행 거리
	private int location;

	public RacingCar() {

		// 객체 생성 시 초기화
		this.location = RACING_START_LOCATION;
	}

	/**
	 * 자동차 주행 거리 리턴
	 * @return : 자동차 주행 거리 정수 리턴
	 */
	public int getDistance() {

		return this.location;
	}

	public void move(CarConditional carConditional) {

		if (carConditional.isMove()) {

			this.location++;
		}
	}
}
