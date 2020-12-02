import static org.assertj.core.api.Assertions.*;

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

}
