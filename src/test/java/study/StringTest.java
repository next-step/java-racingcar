package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	@DisplayName("step1.split test")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}
	
	@Test
	@DisplayName("step1.substring test")
	void substring() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("step1.charAt Exception test")
	void charAt() {
		assertThatThrownBy(() -> { "abc".charAt(5); }).isInstanceOf(StringIndexOutOfBoundsException.class)
													.hasMessageContaining("index");
		
		assertThatExceptionOfType(Throwable.class).isThrownBy(() -> { "abc".charAt(5); })
												.withMessageContaining("range")
												.withMessageMatching("String index out of range: [0-9]*");
	}
}
