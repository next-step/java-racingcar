package carracinggame;

public class Car {
	private int position = 1;

	private String name;

	private final MoveStrategy moveStrategy;

	public Car(String name, MoveStrategy moveStrategy) {
		this.name = name;
		this.moveStrategy = moveStrategy;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void move() {
		if (moveStrategy.isPossibleMove()) {
			position++;
		}
	}
}
