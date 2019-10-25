package step2;

import java.util.concurrent.ThreadLocalRandom;

class Car {

	private static final int LUCKY_THRESHOLD = 4;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private int step;

	void moveIfLucky() {
		if (isLuckRound()) {
			step ++;
		}
	}

	private boolean isLuckRound() {
		return getRandomNumber() >= LUCKY_THRESHOLD;
	}

	/**
	 * LCG 알고리즘을 사용하는 Random 대신
	 * thread-safe하고 가볍고 더 나은 난수 생성 알고리즘을 가진 ThreadLocalRandom을 사용한다
	 *
	 * 테스트를 위해 protected로 선언
	 */
	protected int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(MIN_RANDOM_NUMBER ,MAX_RANDOM_NUMBER + 1);
	}

	int getStep() {
		return this.step;
	}

}
