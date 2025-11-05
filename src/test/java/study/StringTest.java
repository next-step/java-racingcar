package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("1,2를 ,로 split 했을 때 1과 2로 분리된다")
	void splitWithTwoElements() {
	    // Arrange
	    String input = "1,2";

	    // Act
	    String[] results = input.split(",");

	    // Assert
	    assertThat(results).containsExactly("1", "2");
	}

	@Test
	@DisplayName("1을 ,로 split 했을 때 1만 포함하는 배열이 반환된다")
	void splitWithOneElement() {
	    // Arrange
	    String input = "1";

	    // Act
	    String[] results = input.split(",");

	    // Assert
	    assertThat(results).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2)를 substring 했을 때 1,2가 반환된다")
	void substring() {
		// Arrange
		String input = "(1,2)";

		// Act
		String substring = input.substring(1, input.length() - 1);

		// Assert
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("abc를 charAt 했을 때 특정 위치의 문자가 반환된다")
	void charAt() {
		// Arrange
		String input = "abc";

		// Act
		char charAt = input.charAt(2);

		// Assert
		assertThat(charAt).isEqualTo('c');
	}

	@Test
	@DisplayName("abc를 charAt 했을 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
	void charAtException() {
		// Arrange
		String input = "abc";

		// Act & Assert
		assertThatThrownBy(
			() -> input.charAt(3)
		).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
