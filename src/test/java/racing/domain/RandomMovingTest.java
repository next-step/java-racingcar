package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomMovingTest {

	@ParameterizedTest
	@DisplayName("이동값의 판답값에 따라 true, false 를 반환한다.")
	@CsvSource(value = {"1,false","2,false","3,false","4,true","7,true"})
	public void randomMovingCheck(int randomValue, boolean moveFlag) {
		RandomMoving randomMoving = new RandomMoving();
		boolean result = randomMoving.movable(randomValue);

		assertThat(result).isEqualTo(moveFlag);

	}

}