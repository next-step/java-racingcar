package racingcar.model;

public class RacingCar {
	// https://velog.io/@kwj1270/JAVA-%EC%BD%94%EB%93%9C-%EC%BB%A8%EB%B2%A4%EC%85%98
	// 4. 클래스 변수(static) public -> protected -> package(default) -> private
	private static final int INITIAL_POSITION = 0;
	private static final int MOVABLE_MINIMUM_VALUE = 4;

	// 5. 일반 변수 public -> protected -> package(default) -> private
	public int position;

	public RacingCar() {
		this.position = INITIAL_POSITION;
	}

	public String getRacingCarDashString() {
		// #1
//		StringBuilder stringBuilder = new StringBuilder();
//		for (int i = 0; i < this.position; i++) {
//			stringBuilder.append('-');
//		}
//		return stringBuilder.toString();

		// #2
		return new String(new char[this.position]).replace("\0", "-");
	}

	public boolean isMovable(int randomValue) {
		return randomValue >= MOVABLE_MINIMUM_VALUE;
	}

	public void forward() {
		position++;
	}
}
