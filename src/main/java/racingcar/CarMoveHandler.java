package racingcar;

import java.util.Random;

public class CarMoveHandler {
	private static final Random RANDOM = new Random();
	private static final int MAX_BOUND = 10;
	private static final int MIN_MOVE_VALUE = 4;

	private CarMoveHandler() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static boolean canGo() {
		int randomValue = RANDOM.nextInt(MAX_BOUND);
		return randomValue >= MIN_MOVE_VALUE;
	}
}
