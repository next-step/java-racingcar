import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

	@Test
	@DisplayName("요구사항1 - '1,2'을 ,로 String split 했을 때 1과 2로 잘 분리되는지 확인")
	void commaSplitTest() {
		String originString = "1,2";
		String[] splitResultArray = originString.split(",");
		assertThat(splitResultArray).hasSize(2);
		assertThat(splitResultArray).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항1 - '1'을 ,로 String split 했을 때 1만 포함하는 배열이 반환되는지 확인")
	void noCommaSplitTest() {
		String originString = "1";
		String[] splitResultArray = originString.split(",");
		assertThat(splitResultArray).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항2 - '(1,2)'이 주어졌을 때 String substring 으로 ()를 제거하고 1,2를 반환하는지 확인")
	void substringTest() {
		String originString = "(1,2)";
		String substringResult = originString.substring(1, originString.length() - 1);
		assertThat(substringResult).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항3 - 'abc' 가 주어졌을 때 String charAt 으로 특정 위치의 문자를 가져오는지 확인")
	void charAtTest() {
		String originString = "abc";
		assertThat(originString.charAt(0)).isEqualTo('a');
		assertThat(originString.charAt(1)).isEqualTo('b');
		assertThat(originString.charAt(2)).isEqualTo('c');
		assertThat(originString.charAt(2)).isNotEqualTo('a');
	}

	@Test
	@DisplayName("요구사항3 - String charAt 활용 시, 문자열 범위를 벗어나면 StringIndexOutOfBoundsException 발생하는지 확인")
	void charAtStringIndexOutOfBoundsExceptionTest() {
		String originString = "abc";
		assertThatThrownBy(() -> originString.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
