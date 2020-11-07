package nextstep.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

	@Test
	@DisplayName("요구사항 1 split 테스트")
	void splitTest() {
		String[] result = "1,2".split(",");

		assertThat(result).containsExactly("1", "2");
		assertThat(result).contains("1");
	}

	@Test
	@DisplayName("요구사항 2 substring 테스트")
	void substringTest() {
		String result = "(1,2)";
		assertThat(result.substring(1, result.length() - 1)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항 3 charAt 으로 기대값을 찾는다.")
	public void charAtTest1() {
		final String abc = "abc";
		char result = abc.charAt(0);

		assertThat(result).isEqualTo('a');
	}

	@Test
	@DisplayName("요구사항 3 charAt 예외테스트")
	public void charAtTest2() {
		final String abc = "abcdefg";

		assertThatThrownBy(() -> {
			abc.charAt(10);
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range");
	}
}
