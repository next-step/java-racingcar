package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
	private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	@Test
	@DisplayName("0~9까지의 숫자를 랜덤하게 생성한다.")
	void generateTest() {
		for (int i = 0; i < 10000; i++) {
			assertThat(randomNumberGenerator.generate())
				.isGreaterThanOrEqualTo(NumberGenerator.MIN_NUMBER_GREATER_THAN_OR_EQUAL_TO)
				.isLessThan(NumberGenerator.MAX_NUMBER_LESS_THAN);
		}
	}
}
