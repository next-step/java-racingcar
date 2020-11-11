package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomGeneratorTest {
	private RandomGenerator underTest = new RandomGenerator(10);

	@Test
	@DisplayName("랜덤수는 0~9 사이의 수이다.")
	public void test() {
		assertAll(() -> assertTrue(underTest.getRandomNumber() < 10),
				() -> assertFalse(underTest.getRandomNumber() >= 10));
	}
}
