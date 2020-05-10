package stringClassTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringClassTest {

	@Test
	@DisplayName("요구사항 1-1 : 2개 항 분리에 대한 split 메소드 테스트")
	void splitStringArrayHavingTwoNumber() {
		// 요구사항 1-1 : "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2 : 단일 항 분리에 대한 split 메소드 테스트")
	void splitStringArrayHavingOneNumber() {
		// 요구사항 1-2 : "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2 : subString 메소드를 활용한 문자 제거 테스트")
	void subStringRemoveParenthesis() {
		// 요구사항 2 : "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록
		// 구현한다.
		String targetString = "(1,2)";
		assertThat(targetString.substring(targetString.indexOf("(") + 1, targetString.indexOf(")"))).isEqualTo("1,2");
		;
	}

	@Test
	@DisplayName("요구사항 3-1 : 특정 문자열에서 charAt 메소드를 활용하여 특정 위치의 문자 반환 테스트")
	void charAtTest() {
		// 요구사항 3-1 : "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
		String targetString = "abc";
		assertThat(targetString.charAt(0)).isEqualTo('a');
		assertThat(targetString.charAt(1)).isEqualTo('b');
		assertThat(targetString.charAt(2)).isEqualTo('c');
	}

	@Test
	@DisplayName("요구사항 3-2 : charAt 메소드의 예외 케이스 처리 테스트")
	void charAtExceptionTest() {
		// 요구사항 3-2 : String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
		// StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
		int targetIndex = 5;
		String targetString = "abc";

		assertThatThrownBy(() -> {
			assertThat(targetString.charAt(targetIndex)).isEqualTo('a');
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
		  .hasMessageContaining("String index out of range: " + targetIndex);
	}
}
