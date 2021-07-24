package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {
	@Test
	@DisplayName("0~9 사이 랜덤 값을 생성하는 generateForwardValue함수를 호출하여 반환 값이 최소값과 최대값 사이인지 테스트")
	void generateForwardValueTest() {
		int val;

		for (int i = 0 ; i < 100 ; i++) {
			val = Util.generateForwardValue();
			assertThat(val).isGreaterThanOrEqualTo(Util.MIN_VALUE);
			assertThat(val).isLessThanOrEqualTo(Util.MAX_VALUE);
		}
	}
}
