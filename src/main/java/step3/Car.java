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

}
