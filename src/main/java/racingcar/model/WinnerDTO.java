package racingcar.model;

public class WinnerDTO {
	private final Cars cars;

	public Cars cars() {
		return cars;
	}

	private int maxDistance;

	public int maxDistance() {
		return maxDistance;
	}

	public void createMaxDistance(int maxDistance){
		this.maxDistance = maxDistance;
	}

	private final int carNum;

	public int carNum() {
		return carNum;
	}

	public WinnerDTO(Cars cars, int maxDistance, int carNum) {
		this.cars = cars;
		this.maxDistance = maxDistance;
		this.carNum = carNum;
	}
}
