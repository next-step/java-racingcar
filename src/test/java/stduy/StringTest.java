package stduy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	private static final int ONE = 1;

	@Test
	@DisplayName("문자열 split")
	public void split() {
		String data = "1,2";
		String[] result = data.split(",");
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("문자열 소괄호 제거")
	public void substring() {
		String data = "(1,2)";
		String result = data.substring(ONE, data.length() - ONE);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열 특정 위치 문자 가져오기 예외 테스트")
	public void charAt() {
		String data = "abc";

		assertThatThrownBy(() -> {
			data.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");

	}
}
