package carracinggame;

public class Car {
	private int position = 1;

	private MoveStrategy moveStrategy;

	public Car(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public int getPosition() {
		return position;
	}

	public void move(int moveDistance) {
		position = moveStrategy.move(position, moveDistance);
	}
}
