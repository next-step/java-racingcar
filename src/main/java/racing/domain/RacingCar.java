package racing.domain;

import racing.domain.accelerator.DriveAccelerator;

public class RacingCar {

	public static int DEFAULT_THRESHOLD = 4;

	/**
	 * 게임 중 누적주행거리
	 */
	private int mileage = 0;

	DriveAccelerator accelerator;

	public RacingCar(DriveAccelerator accelerator) {
		this.accelerator = accelerator;
	}

	/**
	 * 자동차 주행을 위해 가속페달을 밟아 이동하는 메서드
	 * @return 메서드 호출로 이동한 거리
	 */
	public int move() {
		this.mileage += accelerator.getAmount() > DEFAULT_THRESHOLD ? 1 : 0;
		return this.mileage;
	}
}
