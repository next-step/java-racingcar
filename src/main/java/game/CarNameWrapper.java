package game;

public class CarNameWrapper {

	public static final int MAX_CAR_NAME_LENGTH = 5;

	private final String carName;

	public CarNameWrapper(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("CarName은 5자를 넘을 수 없습니다.");
		}
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}
}
