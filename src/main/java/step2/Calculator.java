package step2;

import java.util.Arrays;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;

public class Calculator {
	
	public static int calculation(String input) {
		validation(input);
		List<String> inputSplit = Arrays.asList(input.split(" "));
		validation(inputSplit);
		int result = Integer.parseInt(inputSplit.get(0));
		for(int i = 1; i < inputSplit.size(); i = i+2) {
			result = Operator.calculate(inputSplit.get(i), result, Integer.parseInt(inputSplit.get(i+1)));
		}
		return result;
    }
	
	private static void validation(String input) {
		if(StringUtils.isBlank(input)) {
			throw new IllegalArgumentException("공백이 포함되어 있습니다.");
		}
	}
	
	private static void validation(List<String> inputSplit) {
		for(String input : inputSplit) {
			validation(input);
		}
		if(inputSplit.size() == 1 || inputSplit.size() % 2 == 0) {
			throw new IllegalArgumentException("연산은 피연산자 2개와 연산자 1개가 필요합니다.");
		}
	}
}
