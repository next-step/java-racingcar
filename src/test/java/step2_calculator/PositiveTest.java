package step2_calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveTest {
	@DisplayName("Positive Class Constructor Test")
	@Test
	void create() {
		final String[] actual = "1,2,6,7".split(",");
		Positive positive = new Positive(actual);
		assertThat(positive.getNumbers()).containsExactly(1, 2, 6, 7);
	}
}
