package step4_racingcar_winner.domain;

import step4_racingcar_winner.service.RandomUtil;

public class Car {
	private static final String NULL_EMPTY = "널이거나 빈값입니다";
	private static final String NAMINGRULE = "자동차 이름을 길게 작성했습니다 ";
	private static final int RULE_NAME_LENGTH_MAX = 5;
	private static final int RULE_FORWARD = 4;
	private static final int RULE_MAX_RANGE = 9;
	private RandomUtil randomUtil;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = isNameLengthAcceptable(name);
	}

	public Car(String name, int position, RandomUtil randomUtil) {
		this.name = isNameLengthAcceptable(name);
		this.position = position;
		this.randomUtil = randomUtil;
	}

	public void tryMove() {
		if (isMovable()) {
			move();
		}
	}

	private boolean isMovable() {
		return RULE_FORWARD < randomUtil.randomNumber(RULE_MAX_RANGE);
	}

	public String isNameLengthAcceptable(String name) {
		if (name == null || name.isBlank()) {
			throw new RuntimeException(NULL_EMPTY);
		}

		if (RULE_NAME_LENGTH_MAX < name.length()) {
			throw new RuntimeException(NAMINGRULE);
		}

		return name;
	}

	private void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}
