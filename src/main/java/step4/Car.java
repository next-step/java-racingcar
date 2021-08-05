package step4;

public class Car {

	private static final int RACE_WIN_RANGE = 4;
	private static final int MOVE_DISTANCE = 1;
	private static final int CAR_INIT_DISTANCE = 0;
	private static final int CAR_NAME_RANGE = 5;

	private String carName;
	private int distance;

	public Car(final String carName) {
		if (carName.length() > CAR_NAME_RANGE) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
		}
		this.carName = carName;
		this.distance = CAR_INIT_DISTANCE;
	}

	public int getDistance() {
		return distance;
	}

	public String getCarName() {
		return carName;
	}

	public void move(int randomNumber) {
		if(randomNumber >= RACE_WIN_RANGE) {
			distance += MOVE_DISTANCE;
		}
	}
}
