package carracinggame;

public class Car {
	private int position = 1;

	private final MoveStrategy moveStrategy;

	public Car(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public int getPosition() {
		return position;
	}

	public void move() {
		if (moveStrategy.isPossibleMove()) {
			position++;
		}
	}
}
