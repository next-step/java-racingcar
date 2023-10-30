import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	public void stringTest1() {
		// 요구사항 1
		String[] numbers = "1,2".split(",");
		String[] number = "1".split(",");
		assertThat(numbers).containsExactly("1", "2");
		assertThat(number).containsExactly("1");
	}

	@Test
	public void stringTest2(){
		// 요구사항 2
		String numbers = "(1,2)";
		numbers = numbers.substring(1, 4);
		assertThat(numbers).isEqualTo("1,2");
	}

	@Test
	@DisplayName("String Index Exception 확인")
	public void stringTest3(){
		// 요구사항 3
		String str = "abc";
		assertThatThrownBy(() -> {
			str.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("out of range: 3");

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					str.charAt(3);
				}).withMessageMatching("String index out of range: \\d");
	}
}
