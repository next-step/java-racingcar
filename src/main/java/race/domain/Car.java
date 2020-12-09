package race.domain;

public class Car {
	public static final int START_DISTANCE = 0;
	private int distance;
	private final MovePolicy movePolicy;
	private CarName name;

	public Car(MovePolicy movePolicy) {
		this.distance = START_DISTANCE;
		this.movePolicy = movePolicy;
	}

	public Car(CarName name, MovePolicy movePolicy) {
		this.name = name;
		this.movePolicy = movePolicy;
	}

	public Car(int distance, CarName name, MovePolicy movePolicy) {
		this.distance = distance;
		this.movePolicy = movePolicy;
		this.name = name;
	}

	public static Car of(MovePolicy movePolicy) {
		return new Car(movePolicy);
	}

	public static Car ofName(CarName carName, MovePolicy movePolicy) {
		return new Car(carName, movePolicy);
	}

	public Car move() {
		if (movePolicy.move()) {
			addDistance();
		}
		return new Car(this.distance, this.name, this.movePolicy);
	}

	private void addDistance() {
		this.distance += movePolicy.distance();
	}

	public int nowDistance() {
		return distance;
	}

	public String getNameValue() {
		return name.getValue();
	}
}
