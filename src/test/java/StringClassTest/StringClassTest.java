package StringClassTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringClassTest {

	@Test
	void splitStringArrayHavingTwoNumber() {
		// 요구사항 1-1 : "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void splitStringArrayHavingOneNumber() {
		// 요구사항 1-2 : "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	void subStringRemoveParenthesis() {
		// 요구사항 2 : "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록
		// 구현한다.
		String targetString = "(1,2)";
		assertThat(targetString.substring(targetString.indexOf("(") + 1, targetString.indexOf(")"))).isEqualTo("1,2");
		;
	}

	@Test
	void charAtTest() {
		// 요구사항 3-1 : "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를
		// 구현한다.
		String targetString = "abc";
		assertThat(targetString.charAt(0)).isEqualTo('a');
		assertThat(targetString.charAt(1)).isEqualTo('b');
		assertThat(targetString.charAt(2)).isEqualTo('c');
	}

	@Test
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
