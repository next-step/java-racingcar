package racing;

public class CarMoveCountDto {
	private final int carMoveCount;

	private CarMoveCountDto(int carMoveCount) {
		this.carMoveCount = carMoveCount;
	}

	public static CarMoveCountDto of(int carMoveCount) {
		return new CarMoveCountDto(carMoveCount);
	}

	public int getCarMoveCount() {
		return carMoveCount;
	}
}
