import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("요구사항 1")
	@Test
	void split()
	{
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
	}

	@DisplayName("요구사항 2")
	@Test
	void subString(){
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("요구사항 3")
	@Test
	void charAt(){
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				"abc".charAt(3);
			}).withMessageMatching("String index out of range: 3");

	}
}
