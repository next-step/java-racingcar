package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

	@Test
	void plus() {
		assertThat(3 + 4).isEqualTo(7);
	}

	@Test
	void minus() {
		assertThat(6 - 2).isEqualTo(4);
	}

	@Test
	void multiply() {
		assertThat(5 * 3).isEqualTo(15);
	}

	@Test
	void divide() {
		assertThat(6 / 3).isEqualTo(2);
	}

}