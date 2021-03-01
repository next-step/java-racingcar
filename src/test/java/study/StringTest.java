package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("1,2가 정확히 split되는지 test")
	void 요구사항_1_1() {
		String[] split = "1,2".split(",");
		assertThat(split).containsExactly("1", "2");
	}

	@Test
	@DisplayName("comma가 없는 케이스에서 배열 체크")
	void 요구사항1_2() {
		String[] onlyOne = "1".split(",");
		assertThat(onlyOne).containsExactly("1");
	}

	@Test
	@DisplayName("substr 첫요소 끝요소")
	void 요구사항2() {
		String param = "(1,2)";
		String result = "1,2";
		assertThat(getStringExceptStartEnd(param))
				.isEqualTo(result);
	}

	@Test
	@DisplayName("charat 이용하여 문자열 인덱스에 있는 문자 확인")
	void 요구사항3_1() {
		String param = "abc";

		assertAll(
				() -> assertEquals(param.charAt(0), "a"),
				() -> assertEquals(param.charAt(1), "b"),
				() -> assertEquals(param.charAt(2), "c")
		);
	}

	@Test
	@DisplayName("charAt 사용시 StringIndexOutOfBoundsException 발생 case")
	void charAt_이용하여_StringIndexOutOfBoundsException발생() {
		String param = "abc";

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> param.charAt(5))
				.withMessageMatching("String index out of range: \\d+");
	}

	public String getStringExceptStartEnd(String param) {
		return param.substring(1, param.length() - 1);
	}
}
