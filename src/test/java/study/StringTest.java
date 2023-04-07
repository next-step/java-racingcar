package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

	@DisplayName("String의 split() 메서드 동작 확인")
	@Test
	void split() {
		assertThat("1,2".split(",")).contains("1", "2");
		assertThat("1".split(",")).containsExactly("1");
	}

	@DisplayName("String의 substring() 메서드 동작 확인")
	@Test
	void substring() {
		assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
	}

	@DisplayName("String의 charAt() 메서드 동작 확인")
	@Test
	void charAt() {
		final String string = "abc";

		assertThat(string.charAt(0)).isEqualTo('a');
		assertThat(string.charAt(1)).isEqualTo('b');
		assertThat(string.charAt(2)).isEqualTo('c');
	}

	@DisplayName("String의 charAt() 메서드에서 StringIndexOutOfBoundsException 예외발생 확인")
	@Test
	void charAtStringIndexOutOfBoundsException() {
		final int outOfIndex = 3;

		assertThatThrownBy(() -> "abc".charAt(outOfIndex))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: " + outOfIndex);
	}

	@DisplayName("String의 isBlank() 메서드 동작 확인")
	@Test
	void isBlank() {
		assertThat("".isBlank()).isTrue();
		assertThat("123".isBlank()).isFalse();
	}
}
