import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("문자열의 쉼표를 구분자로 분리하여 배열을 반환하는 테스트")
	public void splitTest() {
		// given
		String stringWithComma = "1,2";
		String stringWithoutComma = "1";

		// when
		String[] splitWithCommas = stringWithComma.split(",");
		String[] splitWithoutCommas = stringWithoutComma.split(",");

		// then
		assertThat(splitWithCommas).containsExactly("1", "2");
		assertThat(splitWithoutCommas).contains("1");
	}

	@Test
	@DisplayName("문자열의 맨 앞, 맨 뒤 문자를 제외한 문자열을 반환하는 테스트")
	public void substringTest() {
		// given
		String str = "(1,2)";

		// when
		String strAfterSubstring = str.substring(1, str.length() - 1);

		// then
		assertThat(strAfterSubstring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열에서 특정 위치의 문자를 반환하는 테스트")
	public void charAtTest() {
		// given
		String str = "abc";
		char[] results = { 'a', 'b', 'c' };

		// when & then
		// 문자열 내에서 메소드 실행한 경우
		for (int i = 0; i < str.length(); i++) {
			assertThat(str.charAt(i)).isEqualTo(results[i]);
		}

		// 문자열의 길이를 벗어난 인덱스에서 메소드 실행한 경우
		assertThatThrownBy(() -> str.charAt(str.length()))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: " + str.length());
	}
}
