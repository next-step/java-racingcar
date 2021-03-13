package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
	@DisplayName("0~9 사이 난수 생성")
	@Test
	void getZeroToNine() {
		assertThat(new RandomNumberZeroToNine().get()).isBetween(0, 9);
	}

	@DisplayName("테스트를 위해 9만 생성")
	@Test
	void getOnlyNine() {
		assertThat(new RandomNumberOnlyNine().get()).isEqualTo(9);
	}
}