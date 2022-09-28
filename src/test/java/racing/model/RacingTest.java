package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

	@DisplayName("자동차 개수를 입력하면 개수만큼 자동차가 생성된다.")
	@Test
	void generateCars() {
		Racing racing = new Racing(3);
		Assertions.assertThat(racing.getCars()).hasSize(3);
	}
}
