import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringClassTest {

	@Test
	void splitTest() {
		String a = "1,2";
		assertThat(a.split(",")).contains("1", "2");

		String b = "1";
		assertThat(b.split(",")).containsExactly("1");
	}

	@Test
	void substringTest() {
		String a = "(1,2)";
		assertThat(a.substring(1, 4)).isEqualTo("1,2");
	}

	@DisplayName("chatAt 테스트 - 성공 케이스")
	@Test
	void charAtTest() {
		String a = "abc";
		assertThat(a.charAt(1)).isEqualTo("a");
		assertThat(a.charAt(2)).isEqualTo("b");
		assertThat(a.charAt(3)).isEqualTo("c");
	}

	@DisplayName("charAT 테스트 - 실패 케이스")
	@Test
	void charAtTestFailure() {
		String a = "abc";

		assertThatThrownBy(() -> {
			a.charAt(4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range");
	}
}