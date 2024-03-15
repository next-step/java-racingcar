package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NaturalNumberTest {

	@Test
	void 인자로_0이하의_값이_입력되면_IllegalArgumentException을_던진다() {
		int input = 0;

		assertThatThrownBy(() -> new NaturalNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
