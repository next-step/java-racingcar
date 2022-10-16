package study.step5.domain.car;

import study.step5.domain.movestrategy.MoveStrategy;

public class Car {
	private static final String REPEATER = "-";       // 반복할 문자
	private final String name;                        // 자동차 이름
	private int position;                            // 자동차 현재 위치

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	// 자동차의 위치가 1 증가
	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	public Car getByPosition(int position) {
		if (this.position == position) {
			return this;
		}
		return null;
	}
}
