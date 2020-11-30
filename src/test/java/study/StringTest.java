package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

	@Test
	@DisplayName("요구사항 1-1. 문자열을 스플릿 한 후 배열에 해당 값들이 잘 들어있는지(contains) 테스트")
	void isContainsValues_AfterSplitStringList() {
		String input = "1,2";
		String[] splitInput = input.split(",");
		assertThat(Arrays.asList(splitInput)).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2. 문자열을 스플릿 한 후 1개 값을 가진 배열에 해당 값들이 잘 들어있는지(containsExactly) 테스트")
	void isContainsExactly_AfterSplitStringList() {
		String input = "1";
		String[] splitInput = input.split(",");
		assertThat(Arrays.asList(splitInput)).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2. 괄호가 제거되고 문자열이 반환되는지 테스트")
	void isRemovedBracket_fromString() {
		String input = "(1,2)";
		String removedBracketStr = input.substring(1, input.length() - 1);
		String[] splitInput = removedBracketStr.split(",");
		assertThat(Arrays.asList(splitInput)).containsExactly("1", "2");
	}
	/*
	- "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	- String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
	- StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	- JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
	 */
	@Test
	@DisplayName("요구사항 3. 특정위치의 문자열을 가져온다.")
	void returnCertainPositionString_usingCharAt() {
		String input = "abc";
		char selectedInput = input.charAt(1);
		assertThat(input).contains(String.valueOf(selectedInput));
	}

	@Test
	@DisplayName("요구사항 3. StringIndexOutOfBoundsException이 발생하는 부분에 대한 테스트")
	void testStringIndexOutofBoundsException_usingCharAt() {
		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("Index: 2, Size: 2");
	}
}
