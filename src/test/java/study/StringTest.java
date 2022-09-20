package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("문자열 1,2를 split 하면 문자열 배열로 반환한다.")
	void Given_String_When_Split_Then_SplitToArr(){
		// given
		String str = "1,2";

		// when
		String[] strArr = str.split(",");

		// then
		Assertions.assertThat(strArr).contains("1", "2");
	}

	@Test
	@DisplayName("문자열 1을 split 하면 1만을 포함하는 배열을 반환한다.")
	void Given_String_When_Split_Then_ReturnWithoutSeparator(){
		// given
		String str = "1,";

		// when
		String[] strArr = str.split(",");

		// then
		Assertions.assertThat(strArr).containsExactly("1");
	}
}
