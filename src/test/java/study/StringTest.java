package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("1,2를 split하면 1과 2로 분리된다")
	@Test
	void splitNumberWithComma() {
	  	// given
		String number = "1,2";

		// when
		String[] splitResult = number.split(",");

	  	// then
		assertThat(splitResult).containsExactly("1","2");
	}

	@DisplayName("1을 ,로 split하면 1만 포함한 배열이 반환된다")
	@Test
	void splitOneNumber() {
	    // given
		String number = "1";

	    // when
		String[] splitResult = number.split(",");

	    // then
		assertThat(splitResult).contains("1");

	}

	@DisplayName("(1,2)를 substring을 이용해 1,2를 반환한다")
	@Test
	void substringForRemove() {
	    // given
		String number = "(1,2)";

	    // when
		String substringResult = number.substring(1,4);

	    // then
		assertThat(substringResult).isEqualTo("1,2");

	}

	@DisplayName("특정 위치의 문자가 위치 값을 벗어나면 예외를 던진다")
	@Test
	void OutOfBoundsException() {
	    // given
		String data = "abc";
		int dataLength = data.length();

	    // when
	    // then
		assertThatThrownBy(() -> {
			data.charAt(dataLength);
		})
				.isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessage("String index out of range: " + dataLength);

	}

}
