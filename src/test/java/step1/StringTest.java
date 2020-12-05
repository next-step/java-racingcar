package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

	@DisplayName("split : '1,2'을 ,로 split한 결과 배열이 1과 2를 순서대로 포함함")
	@Test
	void requireOne1() {
		String[] result = "1,2".split(",");
		assertThat(result)
			.contains("1")
			.contains("2")
			.containsExactly("1", "2");
	}

	@DisplayName("split : '1'을 ,로 split한 결과 배열이 1만 포함함")
	@Test
	void requireOne2() {
		String[] result = "1".split(",");
		assertThat(result)
			.contains("1")
			.containsExactly("1");
	}

	@DisplayName("substring: (1,2) 값이 주어졌을 때 ()을 제거하고 1,2를 반환함")
	@Test
	void requireTwo() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("charAt: 특정 위치의 문자를 가져올 수 없으면 예외를 발생시킴")
	@Test
	void requireThree() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				"abc".charAt(-1);
			})
			.withMessageMatching("String index out of range: -1");
	}

}
