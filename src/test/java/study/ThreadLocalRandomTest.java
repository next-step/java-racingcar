package study;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 충분히 많은 난수를 만들었을 때 가능한 모든 난수는 생성되었으리라 가정한다
 * ThreadLocalRandom(N, M)을 사용했을 때 [N, M)이 나올 것이다
 */
class ThreadLocalRandomTest {

	@Test
	void threadLocalRandomHasLeftClosedRightOpenInterval() {
		Set<Integer> dataSet = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
			dataSet.add(randomNumber);
		}
		assertThat(dataSet).contains(0);
		assertThat(dataSet).doesNotContain(10);
	}

}
