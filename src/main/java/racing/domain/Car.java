package racing.domain;

public class Car {

	private final Name name;
	private Position position;

	public Car(String carName) {
		name = new Name(carName);
		position = new Position(0);
	}

	public Car(String carName, int position) {
		name = new Name(carName);
		this.position = new Position(position);
	}

	public void move(boolean moveResult) {
		if (moveResult) {
			position = position.move();
		}
	}

	public String printCarName() {
		return name.printName();
	}

	public int printPosition() {
		return position.resultPosition();
	}

	public boolean isWinner(int maxPosition) {
		return position.maxPositionCheck(maxPosition);
	}
}
