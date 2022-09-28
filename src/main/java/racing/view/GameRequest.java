package racing.view;

public class GameRequest {

	private final int carCount;
	private final int times;

	public GameRequest(int carCount, int times) {
		this.carCount = carCount;
		this.times = times;
	}

	public int getCarCount() {
		return carCount;
	}

	public int getTimes() {
		return times;
	}
}
