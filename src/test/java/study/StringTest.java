package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("문자열을 split 하면 문자열 배열을 반환한다.")
	void Given_String_When_Split_Then_SplitToArr(){
		// given
		String str = "1,2";

		// when
		String[] result = str.split(",");

		// then
		assertThat(result).contains("1", "2");
	}

	@Test
	@DisplayName("문자열을 split 하면 구분자를 제외한 배열을 반환한다.")
	void Given_String_When_Split_Then_ReturnWithoutSeparator(){
		// given
		String str = "1,";

		// when
		String[] result = str.split(",");

		// then
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("문자열 (1,2)을 substring 하면 1,2를 반환한다.")
	void Given_String_When_Substring_Then_ReturnWithoutSeparator(){
		// given
		String str = "(1,2)";

		// when
		String result = str.substring(1, str.length() - 1);

		// then
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열의 특정 위치의 문자를 반환한다.")
	void Given_Index_When_CharAt_Then_ReturnIndexOfString(){
		// given
		String str = "abc";
		int index = str.length() - 1;

		// when
		char result = str.charAt(index);

		// then
		assertThat(result).isEqualTo('c');
	}

	@Test
	@DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외를 발생한다.")
	void Given_OutOfIndex_When_CharAt_Then_ThrowException(){
		// given
		String str = "abc";
		int index = str.length();

		// when, then
		assertThatThrownBy(() -> str.charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
