package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "   ", "1 +"})
	void validateTest(String s) {
		assertThatThrownBy(() -> {
			stringCalculator.run(s);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void nullCheckTest() {
		assertThatThrownBy(() -> {
			stringCalculator.run(null);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + a", "a - 1", "a / b", "1 + 2 - %", "1 % 2"})
	void parseErrerTest(String s) {
		assertThatThrownBy(() -> {
			stringCalculator.run(s);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void calcTest() {
		assertThat(stringCalculator.run("1 + 2")).isEqualTo(3);
		assertThat(stringCalculator.run("10 - 4")).isEqualTo(6);
		assertThat(stringCalculator.run("5 * 4")).isEqualTo(20);
		assertThat(stringCalculator.run("12 / 3")).isEqualTo(4);
		assertThat(stringCalculator.run("2 + 3 * 4 / 2")).isEqualTo(10);
	}
}
