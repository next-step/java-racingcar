package race;

public class Car {
	public static final int START_DISTANCE = 0;
	private int distance;
	private final MovePolicy movePolicy;
	private String name;

	public Car(MovePolicy movePolicy) {
		this.distance = START_DISTANCE;
		this.movePolicy = movePolicy;
	}

	public Car(String name, MovePolicy movePolicy) {
		this.name = name;
		this.movePolicy = movePolicy;
	}

	public static Car of(MovePolicy movePolicy) {
		return new Car(movePolicy);
	}

	public static Car ofName(String name, MovePolicy movePolicy) {
		return new Car(name, movePolicy);
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

	public String getName() {
		return name;
	}
}
