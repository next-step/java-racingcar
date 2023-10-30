package ch1;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 요구 사항 1
 * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
 * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
 *
 * 요구 사항 2
 * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
 *
 * 요구 사항 3
 * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
 * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
 * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
 *
 */
public class StringClassTest {

	@Test
	void stringSplitTest() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1", "2");
		String[] result2 = "1".split(",");
		assertThat(result2).containsExactly("1");
	}

	@Test
	void stringSubStringTest() {
		String text = "(1,2)";
		String result = text.substring(1, text.length()-1);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 메소드 이용 특정 위치의 문자 노출")
	void stringCharAtTest() {
		String text = "abc";
		char result1 = text.charAt(0);
		char result2 = text.charAt(2);

		assertThat(result1).isEqualTo('a');
		assertThat(result2).isEqualTo('c');
		assertThatThrownBy(() -> {
			text.charAt(5);
		}).isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range: 5");
	}
}
