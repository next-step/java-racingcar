package study;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class StringTest {

	// 요구사항 1
	@Test
	void split() {
		String[] values = "1,2".split(",");
//		assertThat(values).contains("1");
//		assertThat(values).contains("1", "2");
		assertThat(values).containsExactly("1", "2");	// 순서 보장
	}
	
	// 요구사항 2
	@Test
	void substring() {
		String values = "(1,2)";
		String result = values.substring(values.indexOf("(")+1, values.lastIndexOf(")"));
		assertThat(result).contains("1,2");
	}
	
	// 요구사항 3
	@Test
	void charAt() {
//		assertThatThrownBy(() -> {
//		    "abc".charAt(3);
//		}).isInstanceOf(IndexOutOfBoundsException.class)
//		  .hasMessageContaining("Index: 2, Size: 2");
		
		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			  "abc".charAt(3);
		}).hasToString("Index: \\d+, Size: \\d+");
	}
}