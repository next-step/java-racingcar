package game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

	@Test
	@DisplayName("레이싱카 이름이 5자를 넘지 않는가?")
	void isRight_WhenNameIsLessThan5Words() {
		RacingCar racingCar = new RacingCar("람보르기니", 0);
		assertThat(racingCar.getCarName().length()).isLessThanOrEqualTo(5);
	}

	@Test
	@DisplayName("이름이 5자 이상이면 Exception 처리를 하는가.")
	void isError_WhenNameIsMoreThan5Words() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			RacingCar racingCar = new RacingCar("람보보르기니", 0);
		});
	}
}
