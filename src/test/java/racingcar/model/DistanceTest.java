package racingcar.model;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {
	@DisplayName("자동차를 생성한다")
	@Test
	void 자동차의_거리를_생성한다() {
		Distance distance = new Distance(3);
		assertThat(distance).isEqualTo(new Distance(3));
	}

	@DisplayName("자동차를 생성한다")
	@Test
	void 자동차의_이동거리는_음수가_될_수_없다() {
		assertThatThrownBy(() -> {
			new Distance(-1);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
