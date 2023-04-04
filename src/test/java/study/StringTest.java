package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
	@Test
	@DisplayName("[요구사항 1-1] 문자열에 , 포함되는 경우")
	public void splitWithComma() {
		//given
		String data = "1,2";

		//when
		String[] actual = data.split(",");

		//then
		assertThat(actual).containsExactly("1", "2");
	}

	@Test
	@DisplayName("[요구사항 1-2] 문자열에 , 이 포함되지 않는 경우")
	public void splitWithoutComma() {
		//given
		String data = "1";

		//when
		String[] actual = data.split(",");

		//then
		assertThat(actual).containsExactly("1");
	}

	@Test
	@DisplayName("[요구사항 2] substring으로 () 제거")
	public void removeBrackets() {
		//given
		String data = "(1,2)";

		//when
		String actual = data.substring(data.indexOf("(") + 1, data.indexOf(")"));

		//then
		assertThat(actual).isEqualTo("1,2");
	}

	@Test
	@DisplayName("[요구사항 3-1] 특정 위치의 문자 가져오기")
	public void findChar() {
		//given
		String data = "abc";

		//when
		//then
		char actual1 = data.charAt(0);
		assertThat(actual1).isEqualTo('a');

		char actual2 = data.charAt(1);
		assertThat(actual2).isEqualTo('b');

		char actual3 = data.charAt(2);
		assertThat(actual3).isEqualTo('c');
	}

	@Test
	@DisplayName("[요구사항 3-2] 위치가 벗어날 때 Exception 테스트")
	public void findCharException() {
		//given
		String data = "abc";

		//when
		//then
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char actual = data.charAt(3);
				assertThat(actual).isEqualTo('?');
			}).withMessageMatching("String index out of range: \\d+");
	}
}
