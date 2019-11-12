package step2;

public class Car {

	private int position;

	public int getPosition() {
		return position;
	}

	// 자동차의 위치를 이동
	public int move(boolean isMove) {
		if (isMove) {
			this.position++;
		}
		return this.position;
	}

}
