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

}
