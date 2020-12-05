package race;

public class Car {
	private int distance;
	private final MovePolicy movePolicy;

	private Car(MovePolicy movePolicy) {
		this.movePolicy = movePolicy;
	}

	public static Car of(MovePolicy movePolicy) {
		return new Car(movePolicy);
	}

	public void move() {
		if (movePolicy.move()) {
			addDistance();
		}
	}

	private void addDistance() {
		this.distance += movePolicy.distance();
	}

	public int nowDistance() {
		return distance;
	}
}
