package step2;

import org.junit.platform.commons.util.StringUtils;

/**
 * <pre>
 * step2 사칙연산 계산기
 * 
 * 1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * 3. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * 4. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
 *    즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 *    예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 * 
 * </pre>
 * 
 * @author ddak-ddakong
 */
public class ArithmeticOperationsCalculator {

	private final String REGEX_EXPRESSION = "[0-9]*( [-+*/] [0-9]*)*";
	
	private	final int MIN_EXPRESSION_LENGTH = 1;
	
	private String expression;
	
	public int calculate(String expression) {
		checkInputValueValidation(expression);
		
		this.expression = expression.trim();
		return calculate();
	}
	
	private int calculate() {
		int result = 0;		//결과값
		int value1 = 0;		//연산을 위한 숫자값
		String sign = "";	//연산기호

		String[] expValues = expression.split(" ");
		result = Integer.parseInt(expValues[0]); 
		
		int valuesIndex = 1;
		while ( valuesIndex <= expValues.length - 2 ) {
			sign = expValues[valuesIndex];
			value1 = Integer.parseInt(expValues[valuesIndex + 1]);
			
			result = CalculatorTypeEnum.getCalculatorBySign(sign).calculate(result, value1);
			
			valuesIndex = valuesIndex + 2;
		}
		
		return result;
	}
	
	public void checkInputValueValidation(String input) {
		//1. 입력값이 null이거나 빈 공백 문자열인 경우 IllegalArgumentException throw
		if( StringUtils.isBlank(input) || input.trim().length() < MIN_EXPRESSION_LENGTH ) {
			throw new IllegalArgumentException("입력값 검증 오류 (null 혹은 공란)");
		}
		
		//2. 수식에는 각 문자열 사이에 공백이 있다.
		if( !input.matches(REGEX_EXPRESSION) ) {
			throw new IllegalArgumentException("입력식 구조 오류 (ex. 3 + 1 / 10)");
		}
	}
}
