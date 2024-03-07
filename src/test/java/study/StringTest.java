package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

	@Test
	@DisplayName("AssertThat.contains는 순서를 체크하지 않는다.")
	void test_contains_success() {
		String aspect = "1,2";

		String[] result = aspect.split(",");
		String[] expect = {"2", "1"};

		assertThat(result).contains(expect); // fail
	}
	@Test
	@DisplayName("AssertThat.containsExactly 순서까지 체크한다.")
	void test_containsExactly_fail() {
		String aspect = "1,2";

		String[] result = aspect.split(",");
		String[] expect = {"2", "1"};

		assertThat(result).containsExactly(expect); // fail
	}

}
