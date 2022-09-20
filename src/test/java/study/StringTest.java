package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

	@Test
	@DisplayName("요구사항1 Split Test")
	void splitTest() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
		result = "1".split(",");
		assertThat(result).contains("1");
	}
	
}
