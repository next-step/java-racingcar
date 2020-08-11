package step3;

public class Car {

	private static final int CAN_MOVE_NUM = 4;

	private int record;

	public Car() {
		this.record = 0;
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
			return this.record == anotherCar.record;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
