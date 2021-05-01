package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
	@DisplayName("일정 범위 내 랜덤한 값 추출")
	@Test
	public void testGetRandomInt() {
		//given
		int number1 = 1;
		int number10 = 10;

		//then
		Assertions.assertThat(RandomUtil.getRandomInt(number1)).isEqualTo(0);
		Assertions.assertThat(RandomUtil.getRandomInt(number1)).isLessThan(number1);
		Assertions.assertThat(RandomUtil.getRandomInt(number10)).isLessThan(number10);
	}
}
