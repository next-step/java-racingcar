package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {
	@Test
	@DisplayName("String test - 요구사항 1")
	@Order(1)
	public void String_Split_Test() {
	    // given
		String oneAndTwo = "1,2";
		String one = "1";

	    // when
		String[] oneAndTwoArray = oneAndTwo.split(",");
		String[] oneArray = one.split(",");

	    // then
		assertThat(oneAndTwoArray).contains("1");
		assertThat(oneAndTwoArray).contains("2");
		assertThat(oneAndTwoArray).containsExactly("1", "2");

		assertThat(oneArray).contains("1");
		assertThat(oneArray).containsExactly("1");
	}

	@Test
	@DisplayName("String test - 요구사항 2")
	@Order(2)
	public void String_Substring_Test() {
	    // given
	    String input = "(1,2)";
		String expectedResult = "1,2";

	    // when
		String actualResult = input.substring(1,4);

	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("String test - 요구사항 3 : StringIndexOutOfBoundsException 발생 테스트")
	@Order(3)
	public void String_CharAt_Test() {
	    // given
	    String input = "abc";

	    // when

	    // then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> input.charAt(3)).withMessageMatching("String index out of range: \\d+");
	}
}
