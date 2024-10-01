package step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step3.RacingGame.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
	@Test
	@DisplayName("자동차는 입력받은 n대 만큼 생성되는지 체크하는 테스트")
	void carCountTest() {
		Car[] cars = inputCars(4);
		assertThat(cars).hasSize(4);
	}
}