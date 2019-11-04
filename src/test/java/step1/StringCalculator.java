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

}