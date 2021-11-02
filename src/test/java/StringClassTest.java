import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

	@Test
	void step1_1() {
		// given
		String input = "1,2";

		// when
		String[] inputSplit = input.split(",");

		// then
		assertThat(input).contains(inputSplit);
	}

	@Test
	void step1_2() {
		// given
		String input = "1";

		// when
		String[] inputSplit = input.split(",");

		// then
		String[] result = {"1"};
		assertThat(inputSplit).containsExactly(result);
	}

	@Test
	void step2() {
		// given
		String input = "(1,2)";

		// when
		String substring = input.substring(1, input.length() - 1);

		// then
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열의 길이를 벗어나면 StringIndexOutOfBoundException이 발생한다")
	void step3() {
		// given
		String input = "abc";

		// when
		assertThatThrownBy(() -> {
			input.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageStartingWith("String index out of range");

		// then
	}
}
