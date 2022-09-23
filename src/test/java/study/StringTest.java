package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	@DisplayName("요구사항1 Split Test")
	void splitTest() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
		result = "1".split(",");
		assertThat(result).contains("1");
	}

	@Test
	@DisplayName("요구사항 2 Substring Test")
	void subStringTest() {

		String goal = "(1,2)";
		int startIdx = goal.indexOf("(");
		int endIdx = goal.indexOf(")");
		final String result = goal.substring(startIdx + 1, endIdx);
		assertThat(result).isEqualTo("1,2");

	}

	@Test
	@DisplayName("요구사항 3 charAt메소드에 대한 학습과 IndexOutOfBounds에 대한 학습 테스트")
	void charAtTestAndExceptionTest() {
		String str = "abc";

		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');

		assertThatThrownBy(() -> str.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range");

	}

}
