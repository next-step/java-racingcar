package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class StringClassTest {

	@DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitCommaString() {
		String splitTestString = "1,2";
		String splitTarget = ",";

		assertThat(splitTestString.split(splitTarget)).contains("1", "2");
	}

	@DisplayName("1을 만 ,로 split 했을 때 1만 포함된 배열 반환 확인.")
	@Test
	void splitCommaOnlyOneString() {
		String splitTestString = "1";
		String splitTarget = ",";

		assertThat(splitTestString.split(splitTarget)).containsExactly("1");
	}

	@DisplayName("(1,2) 값에서 ()을 제거하고 1,2를 반환 확인.")
	@Test
	void splitExcludeSpecialCharAndSplit() {
		String targetString = "(1,2)";
		String resultString = targetString.substring(1, 4);
		assertThat(resultString).isEqualTo("1,2");
	}

	@DisplayName("특정 위치의 문자를 가져오는지 확인 한다.")
	@Test
	void whenOutOfIndexThrowsException() {
		String targetString = "abc";

		assertThatThrownBy(() -> targetString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

		assertThatThrownBy(() -> {
			ArrayList<String> list = new ArrayList<>();
			list.add("Hello");
			list.add("World");
			list.get(2);
		}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index: 2, Size: 2");

		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			ArrayList<String> list = new ArrayList<>();
			list.add("Hello");
			list.add("World");
			list.get(3);
		}).withMessageMatching("Index: \\d+, Size: \\d+");

	}
}
