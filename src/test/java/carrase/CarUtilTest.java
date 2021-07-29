package carrase;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarUtilTest {

	@Test
	@DisplayName("0 ~ 9 랜덤 값 구하기")
	void random() {
		int number = CarUtil.makeRadomNumber();

		assertThat(number).isLessThan(10).isGreaterThan(-1);
	}
}
