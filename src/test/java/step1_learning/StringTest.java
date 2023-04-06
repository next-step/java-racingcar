package step1_learning;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringTest {

	public static Stream<Arguments> split4SuccessArguments() {
		return Stream.of(
			Arguments.of(0, 'a'),
			Arguments.of(1, 'b'),
			Arguments.of(2, 'c')
		);
	}

	@DisplayName("요구사항 1")
	@Test
	void split() {
		final String[] actual = "1,2".split(",");
		assertThat(actual).containsExactly("1", "2");
	}

	@DisplayName("요구사항 2")
	@Test
	void subString() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("요구사항3 - charAt을 통한 해당 위치 문자 가져오기 : 성공")
	@MethodSource("split4SuccessArguments")
	@ParameterizedTest
	void testSplit4Success(int index, char expected) {
		var source = "abc";

		var actual = source.charAt(index);

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("요구사항 3")
	@Test
	void charAt() {
		String source = "abc";
		Class expect = StringIndexOutOfBoundsException.class;
		String expectedMsg = "String index out of range";

		assertThatThrownBy(() -> source.charAt(3))
			.isInstanceOf(expect)
			.hasMessageContaining(expectedMsg);

		/*
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				"abc".charAt(3);
			}).withMessageMatching("String index out of range: 3");
		 */
	}
}
