package step4;

public class Car {
	private static final int CAN_MOVE_NUM = 4;

	private String name;
	private int record;

	public Car(String name) {

		this.name = name;
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
