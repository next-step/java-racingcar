package step1.string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	final String COMMA = ",";

	@Test
	void given_string_when_split_then_return_array() {
		final String commaSeparatedNumbers = "1,2";

		final String[] splitStringArray = commaSeparatedNumbers.split(COMMA);

		assertThat(splitStringArray).contains("1", "2");
	}

	@Test
	void given_only_one_number_string_when_split_then_return_array_with_only_one_number() {
		final String onlyOneNumber = "1";

		final String[] splitStringArray = onlyOneNumber.split(COMMA);

		assertThat(splitStringArray).containsExactly("1");
	}

	@Test
	void given_comma_string_with_bracket_when_substring_then_return_string_without_bracket() {
		final String openBracket = "(";
		final String closeBracket = ")";
		final String commaSeparatedNumbersWithBracket = "(1,2)";
		final String expectedString = "1,2";

		final String commaSeparatedNumbersWithoutBracket = commaSeparatedNumbersWithBracket
			.substring(commaSeparatedNumbersWithBracket.indexOf(openBracket) + 1,
				commaSeparatedNumbersWithBracket.indexOf(closeBracket));

		assertThat(commaSeparatedNumbersWithoutBracket).isEqualTo(expectedString);
	}

	@DisplayName("String charAt()이 특정 위치의 문자를 가져오고 위치가 인덱스 범위를 벗어날 경우 익셉션 발생 테스트")
	@Test
	void given_string_when_chatAt_with_index_then_return_char_at_index() {
		final String givenString = "abc";
		final int indexA = 0;
		final int exceptionIndex = 9;

		assertThat(givenString.charAt(indexA)).isEqualTo('a');

		assertThatThrownBy(() -> givenString.charAt(exceptionIndex))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage("String index out of range: %s", exceptionIndex);

	}

}
