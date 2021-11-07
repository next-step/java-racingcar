package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyNumberTest {
	@Test
	void create(){
		assertThat(new MyNumber("1")).isEqualTo(new MyNumber(1));
	}

	@Test
	@DisplayName("myNumber 생성자에 숫자가 아닌 문자가 들어갈 때")
	void myNumberConstructorNotInteger(){
		String str = "one";
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new MyNumber(str);
			})
		;
	}
}
