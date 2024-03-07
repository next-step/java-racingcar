package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void test_split() {
		String input = "1,2";

		String[] result = input.split(",");
		String[] expect = {"1", "2"};

		assertThat(result).contains(expect);
		assertThat(result).containsExactly(expect);
	}

}
