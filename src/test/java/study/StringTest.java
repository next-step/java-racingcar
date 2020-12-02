package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

	@Test
	@DisplayName("요구사항 1-1. \"1,2\" 로 split 했을 때 1과 2로 잘 분리되는지 확인")
	void split1() {
		// given
		String data = "1,2";

		// when
		String[] splitResult = data.split(",");

		// then
		assertThat(splitResult).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2. \"1\" 를 \",\" 로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
	void split2() {
		// given
		String data = "1";

		// when
		String[] splitResult = data.split(",");

		// then
		assertThat(splitResult).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2. \"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 () 를 제거하고 \"1,2\"를 반환하는지 확인")
	void substring() {
		// given
		String data = "(1,2)";

		// when
		String subStringResult = data.substring(1, 4);

		// then
		assertThat(subStringResult).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항 3-1. abc 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 것을 확인")
	void chatAt1() {
		// given
		String data = "abc";

		// when
		char charAtResult = data.charAt(1);

		// then
		assertThat(charAtResult).isEqualTo('b');
	}

	@Test
	@DisplayName("요구사항 3-2. charAt() 메소드로 특정 문자 위치 가져올 때 IndexOutOufBoundException 캐치")
	void chatAt2() {
		// given
		String data = "abc";

		// when
		ThrowableAssert.ThrowingCallable callCharAt = () -> data.charAt(5);

		// then
		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(callCharAt);
	}
}
