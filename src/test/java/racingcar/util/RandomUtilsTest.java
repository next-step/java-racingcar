package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilsTest {
	@DisplayName("기본 0 ~ 9 사이의 랜덤값을 생성 하는지 검증")
	@RepeatedTest(value = 10, name = "{currentRepetition} / {totalRepetitions}")
	void nextInt() {
		// when
		int result = RandomUtils.nextInt();

		// then
		assertThat(result).isBetween(0, RandomUtils.DEFAULT_BOUND - 1);
	}
}
