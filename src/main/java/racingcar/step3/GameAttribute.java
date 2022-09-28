package racingcar.step3;

public class GameAttribute {

	private final int carCount;
	private final int tryCount;

	public GameAttribute(int carCount, int tryCount) {
		this.carCount = carCount;
		this.tryCount = tryCount;
	}

	public int getCarCount() {
		return this.carCount;
	}

	public int getTryCount() {
		return this.tryCount;
	}
}
