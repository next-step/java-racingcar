package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {
	private RandomGenerator underTest = new RandomGenerator();

	@Test
	@DisplayName("랜덤수는 0~9 사이의 수이다.")
	public void test() {
		IntStream.range(0, 10).forEach(i -> assertTrue(underTest.getRandomNumber() < 10));
	}
}
