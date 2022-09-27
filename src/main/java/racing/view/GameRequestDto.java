package racing.view;

public class GameRequestDto {

	private final int carCount;
	private final int times;

	public GameRequestDto(int carCount, int times) {
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
