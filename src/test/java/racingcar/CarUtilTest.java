package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarUtilTest {

	@Test
	@DisplayName("0에서 9사이의 랜덤값을 구한다")
	void randomNumber() {
		assertThat(CarUtil.makeRandomNumber()).isGreaterThan(-1).isLessThan(10);
	}
}
