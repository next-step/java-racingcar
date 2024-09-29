package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("String.split() 에 대한 학습 테스트")
	void splitMethodTest() {
		String numberList = "1,2";
		String singleNumber = "1";

		String[] numberListResult = numberList.split(",");
		String[] singleNumberResult = singleNumber.split(",");

		assertThat(numberListResult).containsExactly("1", "2");
		assertThat(singleNumberResult).contains("1");
	}

	@Test
	@DisplayName("String.substring() 에 대한 학습 테스트")
	void substringMethodTest() {
		String indentString = "(1,2)";
		int stringLength = indentString.length();
		String[] result = indentString.substring(1, stringLength - 1).split(",");

		assertThat(result).contains("1", "2");
	}

	@Test
	@DisplayName("String.charAt() 의 동작 방식과 Exception 처리에 대한 학습 테스트")
	void charAtMethodTest() {
		String abcString = "abc";
		assertThatThrownBy(() -> {
			abcString.charAt(3);  // 크기를 초과할 때
		}).isInstanceOf(IndexOutOfBoundsException.class);
	}
}
