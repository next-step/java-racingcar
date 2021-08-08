package racingcar;

public class Car implements Comparable<Car> {
	private final CarName name;
	private final CarMileage mileage;

	public Car(String name, int mileage) {
		this.name = new CarName(name);
		this.mileage = new CarMileage(mileage);
	}

	public Car(String name) {
		this(name, 0);
	}

	public void move(RacingCarMoveStrategy strategy) {
		if (strategy.isMovable()) {
			this.mileage.increase();
		}
	}

	public CarMileage getMileage() {
		return this.mileage;
	}

	public CarName getName() {
		return this.name;
	}

	@Override
	public int compareTo(Car other) {
		return this.mileage.compareTo(other.getMileage());
	}
}
