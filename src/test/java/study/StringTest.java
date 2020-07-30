package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 테스트")
public class StringTest {

	@Test
	@DisplayName("문자열 나누기 테스트")
	public void splitTest() {
		String value = "1,2";
		String[] splitValues = value.split(",");
		assertThat(splitValues).contains("1");
		assertThat(splitValues).containsExactly("1", "2");
	}

	@Test
	@DisplayName("특정 위치의 문자 제거 테스트")
	public void substringTest() {
		String value = "(1,2)";
		String result = value.substring(1, value.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("특정 문자 위치 잘못 가져올 때 발생하는 예외 테스트")
	public void charAtTest() {
		String value = "abc";

		assertThatThrownBy(() -> value.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
		assertThatThrownBy(() -> value.charAt(3)).hasMessageContaining("String index out of range: 3");
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> value.charAt(3));
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> value.charAt(3))
				.withMessageContaining("String index out of range: 3");
	}

}
