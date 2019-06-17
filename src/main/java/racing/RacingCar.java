package racing;

public abstract class RacingCar {

	// 게임 중 누적주행거리
	private int mileage = 0;

	public int getMileage(){
		return mileage;
	}

	protected void addMileage(int value){
		mileage += value;
	}

	/**
	 * 자동차 주행을 위해 가속페달을 밟는 것을 추상화한 메서드
	 * @param amount 가속페달 가중치
	 */
	abstract void accelerate(int amount);
}
