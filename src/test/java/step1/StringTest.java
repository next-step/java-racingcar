package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

	@Test
	@DisplayName("split 학습 테스트")
	void splitTest() {
		final String delimeter = ",";

		assertThat("1,2".split(delimeter)).containsExactly("1", "2");
		assertThat("1".split(delimeter)).containsExactly("1");
	}

	@Test
	@DisplayName("substring 학습 테스트")
	void subStringTest() {
		String originString = "(1,2)";

		String substring = originString.substring(1, 4);

		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 학습 테스트 - 정상")
	void charAtTest() {
		String originString = "abc";

		char character = originString.charAt(1);

		assertThat(character).isEqualTo('b');
	}

	@Test
	@DisplayName("charAt 학습 테스트 - 범위 밖 인덱스 예외")
	void charAtIndexOutOfBoundTest() {
		String originString = "abc";

		assertThatThrownBy(() -> originString.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}

}
