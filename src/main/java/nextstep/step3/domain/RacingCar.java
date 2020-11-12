package nextstep.step3.domain;

public class RacingCar {
	private static final int BOUND = 10;
	private static final String ERROR_MESSAGE = "움직일 수 있는 숫자는 0보다 크고 10보다 작아야 합니다.";
	private static final String CARNAME_IS_BELOW_FIVE = "자동차 이름은 5자를 넘길 수 없습니다.";
	private int point;
	private String name;

	public RacingCar(String name){
		if (name.length() > 5) {
			throw new IllegalArgumentException(CARNAME_IS_BELOW_FIVE);
		}
		this.name = name;
	}

	public void move(int randomNumber) {
		if (randomNumber >= BOUND || randomNumber < 0 ) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		if (randomNumber >= 4) {
			point++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}
}
