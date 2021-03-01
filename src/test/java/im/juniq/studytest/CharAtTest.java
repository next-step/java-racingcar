package im.juniq.studytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharAtTest {
	@Test
	@DisplayName("charAt() 메소드를 이용해 특정 위치의 문자를 가져온다")
	void testCharAt() {
		String source = "abc";

		assertThat(source.charAt(0)).isEqualTo('a');
	}

	@Test
	@DisplayName("charAt() 메소드를 이용시, 위치값을 벗어나면 예외가 발생한다")
	void testCharAtIndexOutOfBoundsException() {
		String source = "abc";

		assertThatThrownBy(() -> {
			source.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessage("String index out of range: 3");
	}
}
