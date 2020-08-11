package step4;

public class Car {
	private static final int CAN_MOVE_NUM = 4;

	private final String name;
	private int record;

	public Car(String name) {
		this.name = name;
		this.record = 0;
	}

	public String getName() {
		return name;
	}

	public int getRecord() {
		return record;
	}

	public void moveForward(int randomNumber) {
		if (randomNumber >= CAN_MOVE_NUM) {
			record++;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Car) {
			Car anotherCar = (Car) obj;
			return sameValues(this, anotherCar);
		}
		return false;
	}

	private boolean sameValues(Car car, Car anCar) {
		return car.name.equals(anCar.name) && car.record == anCar.record;
	}

	@Override
	public int hashCode() {
		return this.name != null ? this.name.hashCode() : 0;
	}

}
