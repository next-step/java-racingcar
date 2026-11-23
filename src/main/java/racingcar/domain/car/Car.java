package racingcar.domain.car;

public class Car {

	private static final int START_POSITION = 0;
	private static final int MIN_MOVE_VALUE = 4;

	private final Position position;
	private final CarName carName;

	public Car(String carName) {
		this(carName, START_POSITION);
	}

	public Car(String carName, int position) {
		this.carName = new CarName(carName);
		this.position = new Position(position);
	}

	public void go(int number) {
		if (number < MIN_MOVE_VALUE) {
			return;
		}
		position.go();
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return carName.getName();
	}

	public boolean isSamePosition(int position) {
		return position == getPosition();
	}
}
