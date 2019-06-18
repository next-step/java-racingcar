package racing.domain;

public class RacingCar {

	public static int DEFAULT_THRESHOLD = 4;

	// 게임 중 누적주행거리
	private int mileage = 0;

	public int getMileage(){
		return mileage;
	}

	/**
	 * 자동차 주행을 위해 가속페달을 밟아 이동하는 메서드
	 * @param accelerate 가속페달 가중치
	 */
	public void move(int accelerate) {
		this.mileage += accelerate > DEFAULT_THRESHOLD ? 1 : 0;
	}
}
