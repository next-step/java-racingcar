package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void split() {
		String[] split = "1,2".split(",");
		assertThat(split).containsExactly("1", "2");
	}
}
