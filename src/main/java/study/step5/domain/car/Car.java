package study.step5.domain.car;

import study.step5.domain.exception.BadRequestException;
import study.step5.domain.movestrategy.MoveStrategy;

public class Car {
	private static final String REPEATER = "-";		// 반복할 문자
	private final String name;						// 자동차 이름
	private int position;							// 자동차 현재 위치

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	public void validateName(String name) {
		final int MAX_NAME_LENGTH = 5;
		if (name.length() > MAX_NAME_LENGTH) {
			throw new BadRequestException("이름은 5글자를 초과할 수 없습니다.");
		}
	}

	// 자동차의 위치가 1 증가
	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			this.position++;
		}
	}

	public String getRepeater() {
		return REPEATER.repeat(this.position);
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}
}
