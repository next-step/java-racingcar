package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
	private static final Random RANDOM = new Random();
	private static final int MAX_BOUND = 10;

	private RandomNumberGenerator() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static int generateRandomNumber() {
		return RANDOM.nextInt(MAX_BOUND);
	}
}
