package object;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
	@TestFactory
	@DisplayName("요구사항 1")
	Collection<DynamicTest> splitTest() {
		return Arrays.asList(
			DynamicTest.dynamicTest(
				"\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.",
				() -> assertThat("1,2".split(","))
					.containsExactly("1", "2")
			),
			DynamicTest.dynamicTest(
				"\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.",
				() -> assertThat("1".split(","))
					.containsExactly("1")
			)
		);
	}

	@ParameterizedTest
	@ValueSource(strings = "(1,2)")
	@DisplayName("요구사항 2. \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
	void substringTest(String input) {
		String result = input.substring(input.indexOf("(") + 1, input.indexOf(")"));

		assertThat(result).isEqualTo("1,2");
	}

	@TestFactory
	@DisplayName("요구사항 3")
	Collection<DynamicTest> charAtTest() {
		return Arrays.asList(
			DynamicTest.dynamicTest(
				"\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.",
				() -> {
					assertThat("abc".charAt(0)).isEqualTo('a');
					assertThat("abc".charAt(1)).isEqualTo('b');
					assertThat("abc".charAt(2)).isEqualTo('c');
				}
			),
			DynamicTest.dynamicTest(
				"String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.",
				() -> assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
					.isThrownBy(() -> "abc".charAt(10))
					.withMessageMatching("String index out of range: \\d+")
			)
		);
	}
}
