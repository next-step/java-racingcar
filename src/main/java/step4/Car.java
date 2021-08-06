package step4;

public class Car {

	private static final int RACE_WIN_RANGE = 4;
	private static final int MOVE_DISTANCE = 1;

	private Name carName;
	private int distance;

	public Car(final String carName, int distance) {
		this.carName = new Name(carName);
		this.distance = distance;
	}

	public int getMaxDistance(int maxDistance) {
		return maxDistance > distance ? maxDistance : distance;
	}

	public int getDistance() {
		return distance;
	}

	public boolean getStatusWinnerStatus(int maxDistance) {
		return maxDistance == distance;
	}

	public String getCarName() {
		return carName.getName();
	}

	public void move(int randomNumber) {
		if(randomNumber >= RACE_WIN_RANGE) {
			distance += MOVE_DISTANCE;
		}
	}
}
