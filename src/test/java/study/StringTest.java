package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1", "2");
	}
}
