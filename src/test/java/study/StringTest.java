package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void substring() {
		String result = "(1,2)".substring(1,4);
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("특정 위치의 문자를 갖고 오는 테스트")
	@Test
	void charAt() {

		String str = "abc";
		char target_1 = 'b';
		assertThat(target_1).isEqualTo(str.charAt(1));

		assertThatThrownBy(() -> {
			char target_2 = str.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
						.hasMessageContaining("String index out of range: 3");
	}
}
