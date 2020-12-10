package racingCar.domain;

import racingCar.domain.move.MoveUtil;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Car {
	private static final int MOVABLE_MINIMUM_VALUE = 4;
	private static final int CAR_NAME_LENGTH_MAXIMUM_VALUE = 5;
	private int position;
	private String name;
	private MoveUtil moveUtil;

	public Car(MoveUtil moveUtil, String carName) {
		validateCarName(carName);
		this.name = carName;
		this.position = 0;
		this.moveUtil = moveUtil;
	}

	private void validateCarName(String carName) {
		if (carName.length() > CAR_NAME_LENGTH_MAXIMUM_VALUE)
			throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
	}

	public void move() {
		int moveCondition = moveUtil.move();
		if (isMovable(moveCondition)) {
			position++;
		}
	}

	private boolean isMovable(int arg) {
		return arg >= MOVABLE_MINIMUM_VALUE;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public boolean isWinner(int winnerPosition) {
		return position == winnerPosition;
	}
}
