package nextstep.step3.domain;

public class RacingCar {
	private static final int BOUND = 9;
	private static final String ERROR_MESSAGE = "움직일 수 있는 숫자는 0보다 크고 9보다 작아야 합니다.";
	private int point = 1;

	public void move(int randomNumber) {
		if (randomNumber >= BOUND || randomNumber <= 0 ) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		if (randomNumber >= 4) {
			point++;
		}
	}

	public int getPoint() {
		return point;
	}
}
