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
			this.distance += 1;
		}
	}

	public int nowDistance() {
		return distance;
	}
}
