package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
	// 231102 강의 후 셀프 피드백
	// 각 요구사항을 철저히 분석하고, 요구사항별로 Test로 구현한다.

	@Test
	@DisplayName("null 및 빈 값인 경우")
	public void null_및_빈값() {
		assertThat(cal(null)).isEqualTo(0);
		assertThat(cal("")).isEqualTo(0);
	}

	@Test
	@DisplayName("문자 한 개인 경우")
	public void 문자_한개() {
		int result = cal("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("쉼표로만 구분된 문자")
	void 쉼표_구분자() {
		assertThat(cal("1,2,3")).isEqualTo(6);
	}

	@Test
	@DisplayName("콜론으로만 구분된 문자")
	void 콜론_구분자() {
		assertThat(cal("1:2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("콜론과 쉼표가 섞여 구분된 문자")
	void 콜론_쉼표_섞인_구분자() {
		assertThat(cal("1,2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("숫자가 아닌 값 혹은 음수가 전달된 문자")
	void 숫자_이외의_값_혹은_음수() {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("-1"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("야호"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("-1:1:1"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("야호:1:1"));
	}

	//	private String getSeparator(String fullText) {
//		if (fullText.startsWith("//")) {
//			String delimiter = "";
//			delimiter = fullText.split("\n")[0].substring(2,3);
//			return delimiter.equals(".") ? "\\." : delimiter;
//		}
//		if (fullText.contains(",")) {
//			return ",";
//		}
//		if (fullText.contains(":")) {
//			return ":";
//		}
//		return "";
//	}
//
//	private int getSum(String fullText, String separator) {
//		if (fullText.isEmpty()) return 0;
//		fullText = getPureText(fullText);
//		System.out.printf("fullText -> %s  separator -> %s\n", fullText, separator);
//		System.out.println(fullText.contains(separator));
//		System.out.println(separator.equals("."));
//		String[] textArray = fullText.split(separator);
//		System.out.println(Arrays.toString(textArray));
//		int sum = 0;
//		for (String number : textArray) {
//			System.out.println("number ->" + number);
//			if (!isNumber(number)) throw new RuntimeException("TEXT IS NOT A NUMBER");
//			sum += Integer.parseInt(number);
//		}
//		return sum;
//	}
//
//	private String getPureText(String fullText) {
//		if (fullText.startsWith("//")) {
//			return fullText.split("\n")[1];
//		}
//		return fullText;
//	}
}
