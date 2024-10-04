package step3.domain;

public class Car {
	private final int MIN_MOVE_VALUE = 4;
	private final int speed = 1; // 나중에 speed 설정하게 되면 final 제거 및 생성자 추가 필요
	private int position;
	private int moveCalledCount;

	public Car() {
		this.position = 0;
		this.moveCalledCount = 0;
	}

	public void move(int input) {
		if (input >= MIN_MOVE_VALUE) {
			moveForward();
		}
		this.moveCalledCount++;
	}

	public void moveForward() {
		this.position = this.position + this.speed;
	}

	public int getMoveCalledCount() {
		return moveCalledCount;
	}

	public int getPosition() {
		return position;
	}
}
