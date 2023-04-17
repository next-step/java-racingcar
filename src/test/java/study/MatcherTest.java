package study;

import static Stringcalculator.CalculatorUtils.*;
import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Matcher 클래스에 대한 학습 테스트")
public class MatcherTest {

	@DisplayName("Matcher의 group() 메서드 동작 확인")
	@Test
	void group() {
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher("//;\n1;2;3");
		if (matcher.find()) {
			assertThat(matcher.group(1)).isEqualTo(";");
			assertThat(matcher.group(2)).isEqualTo("1;2;3");
		}
	}
}
