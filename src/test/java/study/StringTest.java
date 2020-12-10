package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("요구사항1: split 학습 및 assertj 의 contains/containsExactly 테스트 코드 학습")
	void splitTest() {

		// 문자열을 split 하여 String 배열 리턴
		String[] result = "1,2".split(",");

		/*
		 * Assertj contains(param)
		 * 비교하는 대상에 value 가 포함 여부 확인 메서드
		 */
		assertThat(result).contains("1");    // ture
		assertThat(result).contains("2");    // ture
		//assertThat(result).contains("3");	// false: 포함되지 않은 value

		/*
		 * Assertj containsExactly(params)
		 * 비교하는 대상의 index 와 value 가 동일한지 판단 확인 메서드
		 */
		assertThat(result).containsExactly("1", "2");    // true
		//assertThat(result).containsExactly("1","3");	// false: 포함되지 않은 value 존재
		//assertThat(result).containsExactly("1");		// false: 비교 대상과 동일하지 않다.

		userInputSplitTest("1", new String[] {"1"}); // true
		userInputSplitTest("1,2", new String[] {"1", "2"}); // true

		// false: containsExactly Error
		// 원소의 index 와 value 가 모두 동일해야 한다.
		// userInputSplitTest("1,2", new String[] {"2", "1"});
	}

	@Test
	@DisplayName("요구사항2: subString 활용 학습 ")
	void subStringTest() {

		String data = "(1,2)";

		/*
		 * substring(param1, param2)
		 * 문자열의 시작/ 시작과 끝을 지정한 index 의 문자를 리턴
		 */
		assertThat(data.substring(1, 4)).contains("1,2");

		userInputSubStringTest("(1,2)", "1,2");
		userInputSubStringTest("(1,2,3,4,5)", "1,2,3,4,5");

		// 포함된 문자로만 나열되 있기 떄문에 true
		userInputSubStringTest("(1,2,3,4,5),6,7,8", "1,2,3,4,5");
	}

	@Test
	@DisplayName("요구사항3: charAt() 활용 및 인덱스 참조 에러 대응")
	void checkCharAtTest() {

		userInputCharAtTest("abc", 'b', 1);
		userInputCharAtTest("abed", 'e', 2);
		// userInputCharAtTest("abed", 'c', 2); // false
		// userInputCharAtTest("abed", 'e', 5); // StringIndexOutOfBoundsException Exception

		// 임의로 Exception 을 발생시켜 테스트
		// userInputThrownByTest("apple", 8);
		// userInputExceptionTest("apples", 7);
		// userInputExceptionTest("abide", 6); // 인덱스 예외처리가 일어날 케이스 테스트
		// userInputExceptionTest("abc", 10);

		// Exception 이 발생하지 않는 경우 확인하는 테스트코드
		userInputNotExceptionTest("abed", 3);
		// userInputNotExceptionTest("abed", 8);
	}

	private void userInputNotExceptionTest(String inputTestStr, int index) {

		assertThatCode(
			() -> System.out.println(inputTestStr.charAt(index))

		).doesNotThrowAnyException();
	}

	private void userInputExceptionOfTypeTest(String inputTestStr, int index) {

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {

			//throw new StringIndexOutOfBoundsException();
			System.out.println(inputTestStr.charAt(index));
		}).withMessage("%s!", "@@Oops......@@")
			.withMessageContaining("#####thrown#####")
			.withNoCause();
	}

	private void userInputThrownByTest(String inputTestStr, int index) {

		assertThatThrownBy(() -> {

			System.out.println(inputTestStr.charAt(index)); //throw new StringIndexOutOfBoundsException();

		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("[" + inputTestStr + "] Index: " + index + ", Size: " + inputTestStr.length());

	}

	private void userInputCharAtTest(String inputTestStr, char resultTestCh, int getIndex) {

		assertThat(inputTestStr.charAt(getIndex)).isEqualTo(resultTestCh);
	}

	private void userInputSubStringTest(String inputTestStr, String resultTestStr) {

		String startSeparator = "(";
		String endSeparator = ")";

		String subStringResult = inputTestStr.substring(inputTestStr.indexOf(startSeparator),
			inputTestStr.indexOf(endSeparator));

		assertThat(subStringResult).contains(resultTestStr);
	}

	private void userInputSplitTest(String inputTestStr, String[] resultTestStr) {

		String separator = ",";
		String[] splitResult = inputTestStr.split(separator);

		assertThat(splitResult).contains(resultTestStr);
		assertThat(splitResult).containsExactly(resultTestStr);
	}
}
