package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
	@Test
	@DisplayName("split test")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("substring test")
	void substring() {
		String data = "(1,2)";
		String result = data.substring(1, data.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt을 사용하여 특정 위치의 문자 가져오기")
	void charAtTest(){
		String data = "abc";
		char result = data.charAt(0);
		assertThat(result).isEqualTo('a');
	}

	@Test
	@DisplayName("charAt 사용시 위치값 벗어나면 StringIndexOutOfBoundsException 발생 테스트")
	void charAtExceptionTest() {
		String data = "abc";
		int num = 4;
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				data.charAt(num);
			}).withMessage("String index out of range: %d", num)
		;
	}

}
