package step1;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class JunitString {

	// String 요구사항1
	// "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	// 1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	public int[] splitIntArray(String str) {
		return Arrays.stream(str.split(",")).sorted().mapToInt(Integer::parseInt).toArray();
	}

	// String 요구사항2
	// "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
	public String subStringParenthesis(String str) {
		int index = str.indexOf("(");
		str = str.substring(index + 1, str.length());
		index = str.indexOf(")");
		str = str.substring(0, index);

		return str;
	}

	// String 요구사항3
	// "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	// String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	public char charAtStrReturn(String str, int index) {

		char result = 0;

		try {
			result = str.charAt(index);
		} catch (Exception e) {
			assertThat(e).hasMessage("Index: " + index + ", Size: " + str.length());
		}

		return result;
	}

}
