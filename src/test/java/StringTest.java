import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void given_string_when_split_then_return_array() {
		final String COMMA = ",";
		final String commaSeparatedNumbers = "1,2";
		final String[] expectedArray = new String[] {"1", "2"};

		final String[] splitStringArray = commaSeparatedNumbers.split(COMMA);

		assertThat(splitStringArray).isEqualTo(expectedArray);
	}

	@Test
	void given_only_one_number_string_when_split_then_return_array_with_only_one_number() {
		final String COMMA = ",";
		final String onlyOneNumber = "1";
		final String[] expectedArray = new String[] {"1"};

		final String[] splitStringArray = onlyOneNumber.split(COMMA);

		assertThat(splitStringArray).isEqualTo(expectedArray);
		assertThat(splitStringArray.length).isEqualTo(1);
	}

}
