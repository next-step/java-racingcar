import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
	// 231102 강의 후 셀프 피드백
	// 각 요구사항을 철저히 분석하고, 요구사항별로 Test로 구현한다.
	@Test
	@DisplayName("문자열 계산기")
	public void plusStringCalculator() {
		/*
		 * 쉼표, 혹은 콜론을 구분자로 가지는 문자열을 전달받아 구분자를 기준으로 분리한 각 숫자의 합을 반환
		 * , : 외 커스텀 구분자 지정 가능함. 이 때, 커스텀 구분자는 //X\n1X2X3 과 같이 지정 가능
		 * 숫자 이외의 값 or 음수인 경우 RuntimeException throw
		 * */
		String fullText1 = "1,2,3";
		String fullText2 = "1:2:3";
		String fullText3 = "//.\n1.2.3";
		System.out.println(fullText3);
		System.out.println(getSum(fullText1, getSeparator(fullText1)));
		assertThat(getSum(fullText1, getSeparator(fullText1))).isEqualTo(6);
		assertThat(getSum(fullText2, getSeparator(fullText2))).isEqualTo(6);
		assertThat(getSum(fullText3, getSeparator(fullText3))).isEqualTo(6);
	}


	private boolean isEmptyText(String fullText) {
		return fullText.isEmpty();
	}

	private String getSeparator(String fullText) {
		if (fullText.startsWith("//")) {
			String delimiter = "";
			delimiter = fullText.split("\n")[0].substring(2,3);
			return delimiter.equals(".") ? "\\." : delimiter;
		}
		if (fullText.contains(",")) {
			return ",";
		}
		if (fullText.contains(":")) {
			return ":";
		}
		return "";
	}

	private int getSum(String fullText, String separator) {
		if (fullText.isEmpty()) return 0;
		fullText = getPureText(fullText);
		System.out.printf("fullText -> %s  separator -> %s\n", fullText, separator);
		System.out.println(fullText.contains(separator));
		System.out.println(separator.equals("."));
		String[] textArray = fullText.split(separator);
		System.out.println(Arrays.toString(textArray));
		int sum = 0;
		for (String number : textArray) {
			System.out.println("number ->" + number);
			if (!isNumber(number)) throw new RuntimeException("TEXT IS NOT A NUMBER");
			sum += Integer.parseInt(number);
		}
		return sum;
	}

	private String getPureText(String fullText) {
		if (fullText.startsWith("//")) {
			return fullText.split("\n")[1];
		}
		return fullText;
	}

	private boolean isNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
