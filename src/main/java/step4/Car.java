package step4;

public class Car {

	private static final int RACE_WIN_RANGE = 4;
	private static final int MOVE_DISTANCE = 1;

	private Name carName;
	private Distance distance;

	public Car(final String carName, final int distance) {
		this.carName = new Name(carName);
		this.distance = new Distance(distance);
	}

	public Distance getMaxDistance(int maxDistance) {
		return distance.getMaxDistance(maxDistance);
	}

	public Distance getDistance() {
		return distance;
	}

	public boolean getStatusWinnerStatus(int maxDistance) {
		return maxDistance == distance.getDistance();
	}

	public String getCarName() {
		return carName.getName();
	}

	public void move(NumberGenerator generator) {
		if(generator.getNumber() >= RACE_WIN_RANGE) {
			distance = new Distance(distance.getDistance() + MOVE_DISTANCE);
		}
	}
}
