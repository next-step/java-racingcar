package step2.domain.rules;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator implements NumberGenerator {

	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	/**
	 * LCG 알고리즘을 사용하는 Random 대신
	 * thread-safe하고 가볍고 더 나은 난수 생성 알고리즘을 가진 ThreadLocalRandom을 사용한다
	 */
	@Override
	public int generate() {
		return ThreadLocalRandom.current().nextInt(MIN_RANDOM_NUMBER ,MAX_RANDOM_NUMBER + 1);
	}

}
