package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

	@DisplayName(value = "전진하는 경우 테스트")
	@Test
	public void canMoveForward() {
		assertThat(RacingCar.canMoveForward(4)).isTrue();
	}

}