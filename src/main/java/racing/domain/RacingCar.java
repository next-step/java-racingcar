package racing.domain;

import racing.domain.accelerator.DriveAccelerator;

public class RacingCar implements Comparable<RacingCar>{

	public static int DEFAULT_THRESHOLD = 4;

	/**
	 * 게임 중 누적주행거리
	 */
	private int mileage = 0;

	private String driverName;

	DriveAccelerator accelerator;

	public RacingCar(DriveAccelerator accelerator) {
		this("anymous", accelerator);
	}

	public RacingCar(String driverName, DriveAccelerator accelerator) {
		this.driverName = driverName;
		this.accelerator = accelerator;
	}

	public int getMileage(){
		return mileage;
	}

	public String getDriverName(){
		return driverName;
	}

	/**
	 * 자동차 주행을 위해 가속페달을 밟아 이동하는 메서드
	 * @return 메서드 호출로 이동한 거리
	 */
	public int move() {
		int delta = accelerator.getAmount() > DEFAULT_THRESHOLD ? 1 : 0;
		this.mileage += delta;
		return delta;
	}

	@Override
	public int compareTo(RacingCar other) {
		if(other == null){
			return 1;
		}

		if(this.getMileage() == other.getMileage()){
			return 0;
		}

		return (this.getMileage() > other.getMileage()) ? 1 : -1;
	}
}
