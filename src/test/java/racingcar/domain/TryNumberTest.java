package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

	@Test
	@DisplayName("TryNumber가 0일때 false를 반환한다.")
	void playingTest() {
		assertThat(new TryNumber(1).playing()).isTrue();
		assertThat(new TryNumber(0).playing()).isFalse();
	}

	@Test
	@DisplayName("게임을 진행하면 TryNumber가 1씩 감소한다.")
	void playTest() {
		TryNumber tryNumber = new TryNumber(1);
		tryNumber.play();

		assertThat(tryNumber.playing()).isFalse();
	}
}