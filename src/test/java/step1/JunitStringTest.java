package step1;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String Test")
public class JunitStringTest {

	// String 요구사항1-1
	// "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	@Test
	public void testSplitIntArray1_1() {
		JunitString junitStudy = new JunitString();
		int[] expected = {1, 2};
		int[] actual = junitStudy.splitIntArray("1,2");
		assertArrayEquals(expected, actual, "testSplit1 faild");
	}

	@Test
	public void testSplitIntArray1_2() {
		JunitString junitStudy = new JunitString();
		int[] actual = junitStudy.splitIntArray("1,2");
		assertThat(actual).contains(1, 2);
	}

	// String 요구사항1-2
	// 1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	@Test
	public void testSplitIntArray2() {
		JunitString junitStudy = new JunitString();
		int[] actual = junitStudy.splitIntArray("1");
		assertThat(actual).containsExactly(1);
	}

	// String 요구사항2
	// "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
	@Test
	public void testSubStringParenthesis() {
		JunitString junitStudy = new JunitString();
		String actual = junitStudy.subStringParenthesis("(1,2)");
		assertThat(actual).isEqualTo("1,2");
	}

	// String 요구사항3-1, 3-3
	// "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	// JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
	@Test
	@DisplayName("abc 문자중 지정한 위치 문자 리턴 하는지 여부")
	public void testCharAtStrReturn() {
		JunitString junitStudy = new JunitString();
		assertThat(junitStudy.charAtStrReturn("abc", 1)).isEqualTo('b');
	}

	// String 요구사항3-2
	// String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	@Test
	public void testCharAtStrReturn2() {
		JunitString junitStudy = new JunitString();

		assertThatThrownBy(() -> {
			assertThat(junitStudy.charAtStrReturn("abc", 6));
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("Index: \\d+, Size: \\d+");
	}

}
