package step4;

public class Car {

	private String carName;
	private int distance;

	private final int RACE_WIN_RANGE = 4;
	private final int MOVE_DISTANCE = 1;
	private final int CAR_INIT_DISTANCE = 0;

	public Car(String carName) {
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
