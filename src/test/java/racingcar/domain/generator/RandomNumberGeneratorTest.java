package racingcar.domain.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	void 랜덤생성기는_0에서9까지의_숫자를_만든다() {
		assertThat(new RandomNumberGenerator().generate()).isBetween(0, 9);
	}

}